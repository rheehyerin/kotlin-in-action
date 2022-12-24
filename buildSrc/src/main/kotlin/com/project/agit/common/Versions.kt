package com.project.agit.common
import org.gradle.api.JavaVersion
object Versions {

    // language
    val java = JavaVersion.VERSION_11
    const val kotlin = "1.6.21"

    // spring
    const val springBoot = "2.7.4"
    const val springDependencyManagement = "1.0.14.RELEASE"

    // netty
    const val netty = "4.1.76.Final"
    const val jackson = "2.13.2"
    const val asciidoctor = "3.3.2"
    const val ktlint = "10.3.0"

    // tool
    const val kotlinLogging = "2.1.23"
    const val swagger = "1.6.7"

    // flyway
    const val flyway = "9.8.1"

    // mysql
    const val mysql = "8.0.26"

    // test
    const val springCloudStarterContractStubRunner = "2.2.5.RELEASE"
    const val mockk = "1.12.3"
    const val springMockk = "3.1.1"
    const val kotest = "5.3.0"
    const val okhttp3 = "4.10.0"
    const val jacoco = "0.8.8"
}