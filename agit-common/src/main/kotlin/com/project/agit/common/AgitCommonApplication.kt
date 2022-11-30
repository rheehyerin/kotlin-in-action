package com.project.agit.common

import com.project.agit.common.property.CompanyProperty
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(
    value = [
        CompanyProperty::class
    ]
)
class AgitCommonApplication

fun main(args: Array<String>) {
    runApplication<AgitCommonApplication>(*args)
}
