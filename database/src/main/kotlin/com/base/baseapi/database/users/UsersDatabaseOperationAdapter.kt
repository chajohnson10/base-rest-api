package com.base.baseapi.database.users

import com.base.baseapi.domain.users.UsersDatabaseOperation
import io.klogging.Klogging
import org.springframework.stereotype.Service
import com.base.baseapi.domain.users.User as UserDomain

@Service
internal class UsersDatabaseOperationAdapter(
    private val usersRepository: UsersRepository
) : UsersDatabaseOperation, Klogging {
    override suspend fun get(): List<UserDomain> {
        return try {
            usersRepository.findAll().map { it.toDomain() }
        } catch (ex: Exception) {
            logger.error("Error getting Users ex: $ex")
            return emptyList()
        }
    }

    override suspend fun save(users: List<UserDomain>): List<UserDomain> {
        return try {
            usersRepository.saveAll(users.map { it.toEntity() }).map { it.toDomain() }
        } catch (ex: Exception) {
            logger.error("Error getting Users ex: $ex")
            return emptyList()
        }
    }

    override suspend fun delete(ids: List<Long>): String {
        return try {
            usersRepository.deleteAllById(ids.map { it.toString() })
            "Users deleted successfully $ids"
        } catch (ex: Exception) {
            logger.error("Error getting Users ex: $ex")
            "Posts failed to delete $ids"
        }
    }
}
