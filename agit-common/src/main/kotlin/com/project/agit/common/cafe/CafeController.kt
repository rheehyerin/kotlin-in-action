package com.project.agit.common.cafe

// import org.springframework.web.bind.annotation.GetMapping
// import org.springframework.web.bind.annotation.PostMapping
// import org.springframework.web.bind.annotation.RequestMapping
// import org.springframework.web.bind.annotation.RestController
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/cafe")
class CafeController {
    @GetMapping("/menu")
    fun showMenu(): Int {
        return CafeService().getCoffeeCount()
    }

    @PostMapping("/order")
    fun order(): ResponseEntity<Any> {
        val coffeeCnt = CafeService().orderCoffee()
        return ResponseEntity.ok().body("You have got just 1 coffee, then $coffeeCnt coffees left.")
    }
}
