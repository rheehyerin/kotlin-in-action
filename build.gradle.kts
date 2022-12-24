import com.project.agit.common.Versions
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
        maven {
            url = uri("https://packages.confluent.io/maven")
        }
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-noarg:${com.project.agit.common.Versions.kotlin}")
        classpath("org.jetbrains.kotlin:kotlin-allopen:${com.project.agit.common.Versions.kotlin}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${com.project.agit.common.Versions.kotlin}")
        classpath("org.asciidoctor:asciidoctor-gradle-jvm:${com.project.agit.common.Versions.asciidoctor}")
        classpath("org.flywaydb:flyway-mysql:${com.project.agit.common.Versions.flyway}")
        classpath("mysql:mysql-connector-java:${com.project.agit.common.Versions.mysql}")
    }
}

plugins {
    kotlin("plugin.allopen") version com.project.agit.common.Versions.kotlin
    kotlin("plugin.jpa") version com.project.agit.common.Versions.kotlin
    kotlin("jvm") version com.project.agit.common.Versions.kotlin
    kotlin("plugin.spring") version com.project.agit.common.Versions.kotlin
    kotlin("kapt") version com.project.agit.common.Versions.kotlin

    id("org.springframework.boot") version com.project.agit.common.Versions.springBoot
    id("io.spring.dependency-management") version com.project.agit.common.Versions.springDependencyManagement
    id("org.jlleitschuh.gradle.ktlint") version com.project.agit.common.Versions.ktlint
    id("org.jlleitschuh.gradle.ktlint-idea") version com.project.agit.common.Versions.ktlint
    id("org.asciidoctor.jvm.convert") version com.project.agit.common.Versions.asciidoctor
    id("org.flywaydb.flyway") version com.project.agit.common.Versions.flyway
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

allprojects {
    group = "com.project"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
        maven {
            url = uri("https://packages.confluent.io/maven")
        }
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }
    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

subprojects {

    apply {
        plugin("idea")
        plugin("java")
        plugin("kotlin")
        plugin("kotlin-spring")
        plugin("kotlin-kapt")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
        plugin("org.jlleitschuh.gradle.ktlint")
        plugin("org.asciidoctor.jvm.convert")
    }

    configurations {
        java {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }

    val isMacOS: Boolean = System.getProperty("os.name").startsWith("Mac OS X")
    val architecture = System.getProperty("os.arch").toLowerCase()

    dependencies {

        implementation("org.springframework.boot:spring-boot-starter-actuator")
        implementation("org.springframework.boot:spring-boot-starter-web")

        kapt("org.springframework.boot:spring-boot-configuration-processor")
        annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
        implementation("org.jetbrains.kotlin:kotlin-reflect") // 런타임에 프로그램의 클래스를 확인하기 위해서 사용
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8") // kotlin standard library 사용

        implementation("com.fasterxml.jackson.module:jackson-module-kotlin") // json 객체를 kotlin 객체로 읽고 쓰기 위해서 사용

        // logging
        implementation("io.github.microutils:kotlin-logging-jvm:${Versions.kotlinLogging}")

        // swagger
        implementation("org.springdoc:springdoc-openapi-ui:${Versions.swagger}")

        // flyway
        implementation("org.flywaydb:flyway-core:${Versions.flyway}")

        // test
        // restdocs
        testImplementation("org.springframework.restdocs:spring-restdocs-asciidoctor")
        testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")

        testImplementation("org.springframework.boot:spring-boot-starter-test") {
            exclude(module = "mockito-core")
        }
        testImplementation("io.mockk:mockk:${Versions.mockk}")
        testImplementation("com.ninja-squad:springmockk:${Versions.springMockk}")
        testImplementation("io.kotest:kotest-runner-junit5:${Versions.kotest}")

        testImplementation("com.squareup.okhttp3:okhttp:${Versions.okhttp3}")
        testImplementation("com.squareup.okhttp3:mockwebserver:${Versions.okhttp3}")

        if (isMacOS && architecture == "aarch64") {
            developmentOnly("io.netty:netty-resolver-dns-native-macos:4.1.68.Final:osx-aarch_64")
        }
    }

    val snippetsDir by extra { file("build/generated-snippets") }

    tasks {
        val branch = System.getenv()["GIT_BRANCH"]
        asciidoctor {
            // onlyIf { branch == "develop" }
            dependsOn(test)
            inputs.dir(snippetsDir)
            attributes(
                mapOf("snippets" to snippetsDir) // src/docs/asciidoc/index.adoc 에서 사용할 snippets 변수 설정
            )
        }

        bootJar {
            dependsOn(asciidoctor)

            from("${asciidoctor.get().outputDir}") {
                into("BOOT-INF/classes/static/docs")
            }
        }
    }
}

flyway {
    locations = arrayOf("filesystem:${file("flyway/migration").absolutePath}")
}
