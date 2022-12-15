package com.project.agit.common.company

import com.project.agit.common.company.dto.Company
import com.project.agit.common.company.dto.CompanyRequest
import com.project.agit.common.company.dto.CompanyResponse
import com.project.agit.common.property.CompanyProperty
import org.springframework.stereotype.Service

@Service
class CompanyService(
    private val companyProperty: CompanyProperty
) {
    fun getCompany(companyId: Long): Company {
        return companyProperty.list.first { it.id == companyId }
    }

    fun registerCompany(request: CompanyRequest): Company {
        throwIfExistCompanyName(request.name)
        val list = companyProperty.list
        val newCompany = Company(
            id = (list.size + 1).toLong(),
            name = request.name,
            type = request.type
        )
        list.add(newCompany)
        return newCompany
    }

    fun getCompanyInfo(companyName: String): Company? {
        return companyProperty.list
            .firstOrNull { it.name == companyName }
    }

    fun getCompanyAll(): List<CompanyResponse> {
        return companyProperty.list.map(Company::to).toList()
    }

    internal fun throwIfExistCompanyName(
        name: String,
        message: String = "기존에 동일한 회사 이름이 있습니다."
    ) {
        require(companyProperty.list.firstOrNull { it.name == name } == null) {
            message
        }
    }
}
