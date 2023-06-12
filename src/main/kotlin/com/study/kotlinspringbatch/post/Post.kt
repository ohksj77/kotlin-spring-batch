package com.study.kotlinspringbatch.post

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Post(
    title: String,
    content: String
) {
    @Id @GeneratedValue
    val id: Long? = null

    var title: String = title
        protected set

    var content: String = content
        protected set

    fun update() {
        this.content += "!"
    }
}
