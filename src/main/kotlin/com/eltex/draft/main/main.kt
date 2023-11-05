package com.eltex.draft.main

import com.eltex.draft.service.NodeService

fun main() {
    val nodeService: NodeService = NodeService()

    nodeService.updateText("С возвращением")

    println(nodeService.getNode())
}