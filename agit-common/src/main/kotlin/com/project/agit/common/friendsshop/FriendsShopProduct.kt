package com.project.agit.common.friendsshop

interface FriendsShopProduct {
    val productType: ProductType
    val productName: String
    val price: Int
}

class Doll : FriendsShopProduct {
    override val productType: ProductType = ProductType.DOLL
    override val productName: String
    override val price: Int

    constructor(productName: String = "춘식이", price: Int = 10000) {
        this.productName = productName
        this.price = price
    }
}

abstract class DollDecorator (
    private val doll: Doll
    ) : FriendsShopProduct by doll

enum class ProductType {
    DOLL,
    TUMBLER,
    STICKER,
    PEN
}