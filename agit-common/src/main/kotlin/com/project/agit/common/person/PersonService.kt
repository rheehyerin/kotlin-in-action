package com.project.agit.common.person

import com.project.agit.common.person.dto.Person
import com.project.agit.common.property.PersonProperty
import org.springframework.stereotype.Service

@Service
class PersonService(
    private val personProperty: PersonProperty
) {
    fun getPersonInfo(personName: String): Person? {
        return personProperty.list.stream()
            .filter { it.name == personName }
            .findFirst()
            .orElse(null)
    }
}
