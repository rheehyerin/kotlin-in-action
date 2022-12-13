package com.project.agit.common.person.dto

import com.project.agit.common.person.constant.Location

data class PersonRequest(
    val age: Int?,
    val location: Location?
)
