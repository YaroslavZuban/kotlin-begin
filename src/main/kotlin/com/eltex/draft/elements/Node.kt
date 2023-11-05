package com.eltex.draft.elements

import java.time.Instant

data class Node(val text: String, val createAt: Instant, val updateAt: Instant)