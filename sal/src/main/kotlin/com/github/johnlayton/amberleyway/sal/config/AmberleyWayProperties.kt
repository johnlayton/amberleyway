package com.github.johnlayton.amberleyway.sal.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import javax.validation.Valid

@ConstructorBinding
@ConfigurationProperties(prefix = "client.amberleyway")
data class AmberleyWayProperties(
    @Valid val address: String,
    @Valid val timeOut: Long = 10000L
)
