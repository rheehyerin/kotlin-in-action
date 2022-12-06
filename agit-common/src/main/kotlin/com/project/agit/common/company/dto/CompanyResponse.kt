package com.project.agit.common.company.dto

data class CompanyResponse(
    val id: Long?,
    val name: String?,
    val type: String?
) {
    companion object {
        fun from(company: Company?) =
            CompanyResponse(
                id = company?.id,
                name = company?.name,
                type = company?.type
            )
    }
}
