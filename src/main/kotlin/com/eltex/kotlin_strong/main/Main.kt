package com.eltex.kotlin_strong.main

import com.eltex.kotlin_strong.service.WallService

const val discount = 0.02
const val discountStart = 3_000

fun main() {
    val service1: WallService = WallService()
    println(service1)

    val service2: WallService = WallService()
    println(service2)
}