package com.project.agit.common.friendsshop


import com.project.agit.common.friendsshop.dto.FriendsShopBook
import com.project.agit.common.friendsshop.dto.FriendsShopBook.OrderBook
import com.project.agit.common.friendsshop.dto.FriendsShopReqeust
import com.project.agit.common.friendsshop.dto.FriendsShopResponse
import com.project.agit.common.friendsshop.dto.ProductType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/friendsshop")
class FriendsShopController (
    private val friendsShopService: FriendsShopService
    ) {
    @GetMapping()
    fun ping2() : String {
        return "friendsshop"
    }

    @GetMapping("/buy_test")
    fun buyProduct_test(
        @RequestParam(name = "product", required = true) productType: ProductType
    ): String =
        when (productType) {
            ProductType.DOLL -> "인형이 잘 입력되었습니다"
            else -> "실패"
        }

    @PostMapping("/buy")
    fun buyProduct(
            @RequestBody request: FriendsShopReqeust
    ) = with(friendsShopService.buyProduct(request)) {
        FriendsShopResponse.from(this)
    }

    @GetMapping("/all")
    fun getOrderBook() : List<String> = OrderBook

    @GetMapping("/productList")
    fun getProductList() : String {
        return FriendsShopBook.Dolls.toString() + FriendsShopBook.TumberSets.toString()
    }
}