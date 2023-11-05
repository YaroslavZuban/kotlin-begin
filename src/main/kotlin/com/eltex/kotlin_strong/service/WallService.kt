package com.eltex.kotlin_strong.service

import com.eltex.kotlin_strong.post.Post
import com.eltex.kotlin_strong.post.Attachment
import com.eltex.kotlin_strong.post.Coordinates

class WallService {
    override fun toString(): String {
        return "" + post
    }

    private var post: Post = Post()

    init {
        setId()
    }

    private fun setId() {
        post = post.copy(id = postId)
        postId++
    }

    fun setAuthorId(authorId: Int) {
        post = post.copy(authorId = authorId)
    }

    fun setAuthor(author: String) {
        post = post.copy(author = author)
    }

    fun setAuthorJob(authorJob: String) {
        post = post.copy()
    }

    fun setAuthorAvatar(authorAvatar: String) {
        post = post.copy(authorAvatar = authorAvatar)
    }

    fun setContent(context: String) {
        post = post.copy(context = context)
    }

    fun setPublished(published: String) {
        post = post.copy(published = published)
    }

    fun setLink(link: String) {
        post = post.copy(link = link)
    }

    fun setMentionedMe(mentionedMe: Boolean) {
        post = post.copy(mentionedMe = mentionedMe)
    }

    fun setLinkedByMe(linkedByMe: Boolean) {
        post = post.copy(likeByMe = linkedByMe)
    }

    fun setCoordinates(coordinates: Coordinates) {
        post = post.copy(coordinates = coordinates)
    }

    fun setAttachment(attachment: Attachment) {
        post = post.copy(attachment = attachment)
    }

    fun getPost(): Post {
        return post
    }

    companion object {
        private var postId = 0
    }
}