package com.base.baseapi.restclients.util

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties("api")
data class ApiConfig(
    var baseUrl: String = ""
)
