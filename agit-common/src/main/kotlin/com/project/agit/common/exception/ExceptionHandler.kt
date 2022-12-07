package com.project.agit.common.exception

import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import javax.servlet.http.HttpServletRequest

private val log = KotlinLogging.logger {}

@RestControllerAdvice
class ExceptionHandler() : ResponseEntityExceptionHandler() {
    @ExceptionHandler
    fun handleClientException(
        ex: Exception,
        request: HttpServletRequest
    ): ResponseEntity<Any> {
        log.error { ex }
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(
                AgitErrorResponse(
                    errorCode = "BAD_REQUEST",
                    errorMessage = ex.message ?: ex.localizedMessage
                )
            )
    }
}
