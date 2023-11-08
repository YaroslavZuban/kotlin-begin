package com.eltex.draft.elements

import java.time.Instant

data class Note(val id: Long, val text: String, val createAt: Instant, val updateAt: Instant? = createAt) {
    override fun toString(): String {
        return "Note(id=$id, text='$text')"
    }
}