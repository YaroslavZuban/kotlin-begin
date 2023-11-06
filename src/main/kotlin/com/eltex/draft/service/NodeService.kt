package com.eltex.draft.service

import com.eltex.draft.elements.Node
import java.time.Instant

class NodeService {
    private var node: Node? = null

    fun updateText(text: String) {
        val currentTime = Instant.now()

        node = if (node == null) {
            Node(text, currentTime, currentTime)
        } else {
            node?.copy(text = text, updateAt = currentTime)
        }
    }

    fun getNode(): Node {
        return checkNotNull(node) { "Node is not initialized" }
    }
}