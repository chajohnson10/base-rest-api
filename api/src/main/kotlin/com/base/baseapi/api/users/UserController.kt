package com.base.baseapi.api.users

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/\${spring.application.name}/\${spring.application.version}/users")
internal class UserController (
    private val userAdapter: UserAdapter
) {
    @GetMapping
    suspend fun get(): ResponseEntity<*> {
        return try {
            ResponseEntity(userAdapter.get(), HttpStatus.OK)
        } catch (e: Exception){
            ResponseEntity("Failed to get Users", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PostMapping
    suspend fun save(@RequestBody users: List<User>): ResponseEntity<*> {
        return try {
            ResponseEntity(userAdapter.save(users), HttpStatus.OK)
        } catch (e: Exception){
            ResponseEntity("Failed to save Users", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping
    suspend fun delete(@RequestBody ids: List<Long>): ResponseEntity<*> {
        return try {
            ResponseEntity(userAdapter.delete(ids), HttpStatus.OK)
        } catch (e: Exception){
            ResponseEntity("Failed to delete Users", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}