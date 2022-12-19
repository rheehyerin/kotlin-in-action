package com.project.agit.common.friendsshop.dto


interface FriendsShopProduct {
    val productType: ProductType
    val productName: String
    val price: Int
    var counts: Int
}

class Product : FriendsShopProduct {
    override val productType: ProductType = ProductType.UNKNOWN
    override val productName: String
    override val price: Int
    override var counts: Int

    constructor(productName: String, price: Int) {
        this.productName = productName
        this.price = price
        this.counts = 100
    }
}

class DollDecorator (
    private val product: Product
    ) : FriendsShopProduct by product {
    override val productType: ProductType = ProductType.DOLL
}

class TumblerDecorator (
    private val product: Product
) : FriendsShopProduct by product {
    override val productType: ProductType = ProductType.TUMBLER
}

class StickerDecorator (
    private val product: Product
) : FriendsShopProduct by product {
    override val productType: ProductType = ProductType.STICKER
}

class PenDecorator (
    private val product: Product
) : FriendsShopProduct by product {
    override val productType: ProductType = ProductType.PEN
}

enum class ProductType {
    UNKNOWN,
    DOLL,
    TUMBLER,
    STICKER,
    PEN
}