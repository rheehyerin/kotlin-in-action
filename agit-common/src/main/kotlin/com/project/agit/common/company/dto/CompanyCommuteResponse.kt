package com.project.agit.common.company.dto

data class CompanyCommuteResponse(
    val companyName: String,
    val personName: String
) {
    companion object {
        fun from(companyName: String, personName: String) {
            CompanyCommuteResponse(
                companyName = companyName,
                personName = personName
            )
        }
    }
}
