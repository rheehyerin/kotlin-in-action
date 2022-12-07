package com.project.agit.common.person.dto

import com.project.agit.common.person.constant.Location

data class PersonResponse(
    val name: String?,
    val age: Int?,
    val location: Location?
) {
    companion object {
        fun from(person: Person?) =
            PersonResponse(
                name = person?.name,
                age = person?.age,
                location = person?.location
            )
    }
}
