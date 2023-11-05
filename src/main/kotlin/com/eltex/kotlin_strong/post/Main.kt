package com.eltex.kotlin_strong.post

import com.eltex.kotlin_strong.post.Post

const val discount = 0.02
const val discountStart = 3_000

fun main() {
    val post = Post("content", "author", 100)
    val updated = post.copy(content = "new content")


    println(updated)
}