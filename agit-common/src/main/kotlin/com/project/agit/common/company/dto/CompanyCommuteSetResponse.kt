package com.project.agit.common.company.dto

data class CompanyCommuteSetResponse(
    val companyName: String,
    val commutePersonList: List<String>
) {
    companion object {
        fun from(companyName: String, set: Set<String>) {
            CompanyCommuteSetResponse(
                companyName = companyName,
                commutePersonList = set.toList()
            )
        }
    }
}
