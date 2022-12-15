package com.project.agit.common.person.constant

enum class Location(
    val description: String
) {
    LOBBY("로비"),
    CAFE("메인카페"),
    KAKAO_PAY_SEC("카카오페이증권"),
    KAKAO_FRIENDS_SHOP("카카오프렌즈샵")
    ;

    // 필드 값 캐싱
    companion object {
        private val DESCRIPTION_CACHE: Map<String, Location> =
            values().associateBy { it.description }

        fun findByDescription(description: String) = DESCRIPTION_CACHE[description]
    }
}
