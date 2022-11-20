package com.project.agit.common.ping

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PingController {
    companion object {
        const val PING_API_PATH = "/api/ping"
    }

    @GetMapping(PING_API_PATH)
    fun ping(): String {
        return "pong"
    }
}
