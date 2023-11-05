package com.eltex.kotlin_strong.user

import org.jetbrains.annotations.Nullable

data class User(
    val id: Long = 0L,
    val login: String = "",
    val name: String = "",
    @Nullable val avatar: String? = null
) {
    data class Builder(
        private var id: Long = 0,
        private var login: String = "",
        private var name: String = "",
        private var avatar: String? = null
    ) {
        fun setId(id: Long) = apply { this.id = id }
        fun setLogin(login: String) = apply { this.login = login }
        fun setName(name: String) = apply { this.name = name }
        fun setAvatar(avatar: String?) = apply { this.avatar = avatar }
        fun build() = User(id, login, name, avatar)
    }
}