package com.project.agit.common.friendsshop

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestMapping

@RestController
@RequestMapping("/friendsshop")
class FriendsShopController (
    private val friendsShopService: FriendsShopService
    ) {
    @GetMapping()
    fun ping2() : String {
        return "friendsshop"
    }

    @GetMapping("/buy")
    fun buyProduct(
        @RequestParam(name = "product", required = true) productType: ProductType
    ): String =
        when (productType) {
            ProductType.DOLL -> "인형이 잘 입력되었습니다"
            else -> "실패"
        }

}