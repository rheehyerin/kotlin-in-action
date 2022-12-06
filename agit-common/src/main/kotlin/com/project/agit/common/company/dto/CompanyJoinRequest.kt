package com.project.agit.common.company.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class CompanyJoinRequest(
    val companyName: String,
    val personName: String
)
