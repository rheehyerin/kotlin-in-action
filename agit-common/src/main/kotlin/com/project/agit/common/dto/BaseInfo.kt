package com.project.agit.common.dto

import java.time.LocalDateTime

abstract class BaseInfo(
    open var createAt: LocalDateTime = LocalDateTime.now(),
    open var createBy: String = "",
    open var updateAt: LocalDateTime = LocalDateTime.now(),
    open var updateBy: String = ""

)
