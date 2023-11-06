package com.eltex.kotlin_strong.post

data class Post(
    val id: Int = 0,
    val authorId: Int = 0,
    val author: String = "",
    val authorJob: String = "",
    val authorAvatar: String = "",
    val context: String = "",
    val published: String = "",
    val link: String = "",
    val mentionedMe: Boolean = false,
    val likeByMe: Boolean = false,
    val coordinates: Coordinates? = null,
    val attachment: Attachment? = null
) {
    data class Builder(
        private var id: Int = 0,
        private var authorId: Int = 0,
        private var author: String = "",
        private var authorJob: String = "",
        private var authorAvatar: String = "",
        private var context: String = "",
        private var published: String = "",
        private var link: String = "",
        private var mentionedMe: Boolean = false,
        private var likeByMe: Boolean = false,
        private var coordinates: Coordinates,
        private var attachment: Attachment
    ) {
        fun setId(id: Int) = apply { this.id = id }

        fun setAuthorId(authorId: Int) = apply { this.authorId = authorId }

        fun setAuthor(author: String) = apply { this.author = author }

        fun setAuthorJob(authorJob: String) = apply { this.authorJob = authorJob }

        fun setAuthorAvatar(authorAvatar: String) = apply { this.authorAvatar = authorAvatar }

        fun setContext(context: String) = apply { this.context = context }

        fun setPublished(published: String) = apply { this.published = published }

        fun setLink(link: String) = apply { this.link = link }

        fun setMentionedMe(mentionedMe: Boolean) = apply { this.mentionedMe = mentionedMe }

        fun setLikeByMe(likeByMe: Boolean) = apply { this.likeByMe = likeByMe }

        fun setCoordinates(coordinates: Coordinates) = apply { this.coordinates = coordinates }

        fun setAttachment(attachment: Attachment) = apply { this.attachment = attachment }

        fun build(): Post {
            return Post(
                id, authorId, author, authorJob,
                authorAvatar, context, published, link,
                mentionedMe, likeByMe, coordinates, attachment
            )
        }
    }
}