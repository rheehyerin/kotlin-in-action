package com.project.agit.common.friendsshop

import com.project.agit.common.friendsshop.dto.FriendsShopBook
import com.project.agit.common.friendsshop.dto.FriendsShopBook.OrderBook
import com.project.agit.common.friendsshop.dto.FriendsShopReqeust
import com.project.agit.common.friendsshop.dto.FriendsShopResponse
import com.project.agit.common.friendsshop.dto.ProductType
import org.springframework.stereotype.Service

@Service
class FriendsShopService() {

    fun buyProduct(product: FriendsShopReqeust) : String {
        when (product.productType) {
            ProductType.DOLL -> FriendsShopBook.Dolls
                    .find { it.productName == product.productName }
                    ?.let{ it.counts-- }  ?: throw IllegalArgumentException("No Dolls ${product.productName}")
            ProductType.TUMBLER -> FriendsShopBook.TumberSets
                .find { it.productName == product.productName }
                ?.let{ it.counts-- } ?: throw IllegalArgumentException("No Tumbler the name of ${product.productName}")
            else -> throw IllegalArgumentException("None Product Type ${product.productName}")
        }
        OrderBook.add("${product.personName}이 ${product.productName}을 구매하셨습니다")
        return product.productName
    }

   /*
    fun showList() : List<String> {
        var productList = mutableListOf<String>()
        var iterator = FriendsShopBook.Dolls?.iterator()
        while (iterator.hasNext())
        {

        }
    }
    */
}