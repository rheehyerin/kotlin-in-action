plugins {
	kotlin("jvm") version "1.6.21"
	`kotlin-dsl`
}

group = "com.project"
version = "0.0.1.SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-stdlib")
	compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
}