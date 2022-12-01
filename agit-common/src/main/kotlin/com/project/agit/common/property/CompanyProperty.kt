package com.project.agit.common.property

import com.project.agit.common.company.dto.Company
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "agit.company")
@ConstructorBinding
data class CompanyProperty(
    val list: MutableList<Company>
)
