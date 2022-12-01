package com.project.agit.common.company.dto

import com.project.agit.common.dto.BaseInfo

data class Company(
    val id: Long,
    val name: String,
    val type: String
) : BaseInfo() {
    fun to(): CompanyResponse =
        CompanyResponse(
            id = id,
            name = name,
            type = type
        )
}
