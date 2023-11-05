package com.eltex.kotlin_strong.post

enum class Level {
    SILVER,
    PRO,
    GOLD,
    ;

    companion object {
        fun fromString(input: String): Level {
            return when (input) {
                "SILVER", "silver" -> SILVER
                "PRO", "pro" -> PRO
                "GOLD", "gold" -> GOLD

                else -> error("Unknown input $input")
            }
        }
    }
}