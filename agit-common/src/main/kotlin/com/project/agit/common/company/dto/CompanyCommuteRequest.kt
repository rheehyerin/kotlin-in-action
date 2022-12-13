package com.project.agit.common.company.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class CompanyCommuteRequest(
//    val companyName: String,  // TODO 회사 이동이 가능할 때 쓰일 예정
    val personName: String
)
