package com.project.agit.common.company

import com.project.agit.common.company.dto.CompanyCommuteRequest
import com.project.agit.common.company.dto.CompanyCommuteResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/company/commute")
class CompanyCommuteController(
    private val companyCommuteService: CompanyCommuteService
) {
    @PostMapping("/in")
    fun goToWorkCompany(
        @RequestBody request: CompanyCommuteRequest
    ) = with(companyCommuteService.goToWorkCompany(request)) {
        "ok"
    }

    @PostMapping("/out")
    fun getOffWorkCompany(
        @RequestBody request: CompanyCommuteRequest
    ) = with(companyCommuteService.getOffWorkCompany(request)) {
        "ok"
    }

    @GetMapping("/info")
    fun getCommuteCompany(
        @RequestParam("company_name") companyName: String,
        @RequestParam("person_name") personName: String?
    ) = with(companyCommuteService.getCommuteCompany(companyName, personName)) {
//        CompanyCommuteSetResponse.from(companyName, this) // FIXME set 형태 반환 로직 처리 필요
        this
    }

    @GetMapping("/person")
    fun getCommuteCompanyPerson(
        @RequestParam("company_name") companyName: String,
        @RequestParam("person_name") personName: String
    ) = with(companyCommuteService.getCommutePerson(companyName, personName)) {
        CompanyCommuteResponse.from(companyName, this)
    }
}
