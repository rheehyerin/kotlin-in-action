package com.project.agit.common.friendsshop.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming


data class FriendsShopReqeust (
    val personName: String,
    val productType: ProductType,
    val productName: String
)