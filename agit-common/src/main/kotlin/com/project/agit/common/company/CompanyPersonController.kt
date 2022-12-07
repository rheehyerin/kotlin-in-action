package com.project.agit.common.company

import com.project.agit.common.company.dto.CompanyJoinRequest
import com.project.agit.common.company.dto.CompanyPersonResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/company/join")
class CompanyPersonController(
    private val companyPersonService: CompanyPersonService
) {
    @PostMapping("")
    fun join(
        @RequestBody request: CompanyJoinRequest
    ) = with(companyPersonService.join(request)) {
        "ok"
    }

    @GetMapping("")
    fun getCompanyJoinPersons(
        @RequestParam("company_name") companyName: String
    ) = with(companyPersonService.getCompanyJoinPersons(companyName)) {
        this
    }

    @GetMapping("/person")
    fun getPersonCompany(
        @RequestParam("person_name") personName: String
    ) = with(companyPersonService.getPersonCompany(personName)) {
        CompanyPersonResponse.from(this)
    }
}
