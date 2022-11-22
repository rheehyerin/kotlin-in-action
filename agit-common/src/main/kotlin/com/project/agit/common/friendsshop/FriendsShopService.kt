package com.project.agit.common.friendsshop

import org.springframework.stereotype.Service

@Service
class FriendsShopService() {
    fun getList(): String {
        return "~ 제품이 있습니다"
    }

    fun buyProduct(product: FriendsShopProduct) : String {
        return "제품이 정상 구매 되었습니다"
    }
}