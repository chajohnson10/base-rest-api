package com.base.baseapi.api.util

import io.klogging.NoCoLogging
import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.FilterConfig
import jakarta.servlet.ServletException
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import java.io.IOException

// ONLY FOR LOCAL TESTING
@Component
class CrossOriginFilter : Filter, NoCoLogging {

    @Throws(IOException::class, ServletException::class)
    override fun doFilter(req: ServletRequest, res: ServletResponse, chain: FilterChain) {
        try {
            val request = req as HttpServletRequest
            val response = res as HttpServletResponse
            response.setHeader("Access-Control-Allow-Origin", "*")
            response.setHeader("Access-Control-Allow-Headers", "*")
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE")
            response.setHeader("Access-Control-Max-Age", "0")
            // response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate")
            // response.setHeader("Pragma", "no-cache")
            response.setHeader("Expires", "0")
            if (request.method == "OPTIONS") {
                response.status = HttpServletResponse.SC_OK
            } else {
                chain.doFilter(req, response)
            }
        } catch (ex: Exception) {
            logger.error("Error in CrossOriginFilter ex: $ex", ex)
        }
    }

    override fun init(filterConfig: FilterConfig?) {
        logger.info("Initialize the filter")
    }

    override fun destroy() {
        logger.info("Initialize the filter")
    }
}
