@file:Suppress("NOTHING_TO_INLINE")
package com.project.agit.common

import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.extra
import org.gradle.kotlin.dsl.invoke
import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.version
import org.gradle.kotlin.dsl.withType
import org.gradle.plugin.use.PluginDependenciesSpec
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

inline fun PluginDependenciesSpec.registerKotlin(
    version: String = Versions.kotlin
) {
    kotlin("jvm") version version
    kotlin("plugin.spring") version version
}

inline fun PluginDependenciesSpec.registerPlugin() {
    id("org.springframework.boot") version Versions.springBoot
    id("io.spring.dependency-management") version Versions.springDependencyManagement
    id("org.asciidoctor.convert") version Versions.asciidoctor
    id("org.jlleitschuh.gradle.ktlint") version Versions.ktlint
}

inline fun Project.applyPlugins() {
    apply(plugin = "idea")
    apply(plugin = "java")
    apply(plugin = "kotlin")
    apply(plugin = "kotlin-spring")
    apply(plugin = "kotlin-kapt")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "com.google.cloud.tools.jib")
    apply(plugin = "org.asciidoctor.convert")
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
}

inline fun Project.applyKotlinOptions() {
    // ->for spring rest doc
    val snippetsDir by extra { file("build/generated-snippets") }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }

    tasks.withType<Test>().configureEach {
        useJUnitPlatform()
        outputs.dir(snippetsDir)
    }
}