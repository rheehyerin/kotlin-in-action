package com.project.agit.common.company

import com.project.agit.common.company.dto.CompanyRequest
import com.project.agit.common.company.dto.CompanyResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/company")
class CompanyController(
    private val companyService: CompanyService
) {

    @GetMapping("/{company_id}")
    fun getCompany(
        @PathVariable("company_id") companyId: Long
    ) = with(companyService.getCompany(companyId)) {
        CompanyResponse.from(this)
    }

    @PostMapping("")
    fun createCompany(
        @RequestBody request: CompanyRequest
    ) = with(companyService.registerCompany(request)) {
        CompanyResponse.from(this)
    }

    @GetMapping("/info")
    fun getCompanyInfo(
        @RequestParam("company_name") companyName: String
    ) = with(companyService.getCompanyInfo(companyName)) {
        CompanyResponse.from(this)
    }

    @GetMapping("/all")
    fun getCompanyAll() = with(companyService.getCompanyAll()) {
        this
    }
}
