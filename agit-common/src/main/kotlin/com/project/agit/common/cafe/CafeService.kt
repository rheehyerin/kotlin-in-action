package com.project.agit.common.cafe

class CafeService {
    companion object {
        var coffee = 100
    }

    fun getCoffeeCount(): Int {
        return coffee
    }

    fun orderCoffee(): Int {
        coffee -= 1
        return this.getCoffeeCount()
    }
}
