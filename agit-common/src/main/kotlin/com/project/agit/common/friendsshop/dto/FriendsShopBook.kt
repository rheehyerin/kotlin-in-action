package com.project.agit.common.friendsshop.dto

import java.util.TreeMap

object FriendsShopBook {
    val Dolls = setOf(DollDecorator(Product("어피치", 15000)), DollDecorator(Product("라이언", 20000)))
    val TumblerSets = setOf(TumblerDecorator(Product("스타벅스", 35000)), TumblerDecorator(Product("탐스", 40000)))
    val OrderBook = mutableListOf<String>()
}
