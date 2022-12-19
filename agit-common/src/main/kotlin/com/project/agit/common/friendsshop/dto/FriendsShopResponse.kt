package com.project.agit.common.friendsshop.dto

data class FriendsShopResponse (
    val productName: String
) {
    companion object {
        fun from (productName: String) {
            FriendsShopResponse(
                productName = productName
            )
        }
    }
}
