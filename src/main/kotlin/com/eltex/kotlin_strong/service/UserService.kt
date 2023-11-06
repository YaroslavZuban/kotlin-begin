package com.eltex.service


import com.eltex.kotlin_strong.exceptions.NotFoundException
import com.eltex.kotlin_strong.user.User
import java.util.function.Predicate

class UserService(var userId: Long) {
    private val users: MutableList<User> = mutableListOf()

    fun save(user: User) {
        if (user.id != 0L) {
            val userEdit = getById(user.id).copy(login = user.login, name = user.name, avatar = user.avatar)
        } else {
            val newUser = user.copy(id = userId)
            userId++
            users.add(newUser)
        }
    }

    fun removeById(userId: Long) {
        if (userId < 0) {
            throw NotFoundException("There is no user with this ID")
        }

        users.removeIf(Predicate<User> { user: User -> user.id == userId })
    }

    fun getById(userId: Long): User {
        return users.stream()
            .filter(Predicate<User> { user: User -> user.id == userId })
            .findFirst()
            .orElseThrow<RuntimeException> { NotFoundException("There is no user with this ID.") }
    }

    val all: List<Any>
        get() = users
}