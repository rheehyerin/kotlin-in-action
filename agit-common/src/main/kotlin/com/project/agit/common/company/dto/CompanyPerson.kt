package com.project.agit.common.company.dto

import com.project.agit.common.person.dto.Person

data class CompanyPerson(
    val companyId: Long, // company 유니크 id
    val person: Person, // 사람 정보
    val team: String?, // 팀
    val isJoin: Boolean = false // 입사 여부
) {
    fun to(): CompanyPersonResponse =
        CompanyPersonResponse(
            companyId = companyId,
            person = person,
            team = team,
            isJoin = isJoin
        )
}
