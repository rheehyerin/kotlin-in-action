package com.project.agit.common

import com.project.agit.common.property.CompanyProperty
import com.project.agit.common.property.PersonProperty
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(
    value = [
        CompanyProperty::class,
        PersonProperty::class
    ]
)
class AgitCommonApplication

fun main(args: Array<String>) {
    runApplication<AgitCommonApplication>(*args)
}
