package com.eltex.service


import com.eltex.kotlin_strong.exceptions.NotFoundException
import com.eltex.kotlin_strong.user.User
import java.util.function.Predicate

@Suppress("DEPRECATED_IDENTITY_EQUALS")
class UserService {
    private val users: MutableList<User> = mutableListOf()
    private var USER_ID: Long = 1L

    fun save(user: User) {
        if (user.id != 0L) {
            val userEdit = getById(user.id).copy(login = user.login, name = user.name, avatar = user.avatar)
        } else {
            val newUser = user.copy(id = USER_ID)
            USER_ID++
            users.add(newUser)
        }
    }

    fun removeById(userId: Long) {
        if (userId < 0) {
            throw NotFoundException("There is no user with this ID")
        }

        users.removeIf(Predicate<User> { user: User -> user.id === userId })
    }

    fun getById(userId: Long): User {
        return users.stream()
            .filter(Predicate<User> { user: User -> user.id === userId })
            .findFirst()
            .orElseThrow<RuntimeException> { NotFoundException("There is no user with this ID.") }
    }

    val all: List<Any>
        get() = users
}