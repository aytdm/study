package com.aytdm.hellokotlin.domain

import format
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne
import toSlug

@Entity
class Article(
  var title: String,
  var headline: String,
  var content: String,
  @ManyToOne var author: User,
  var slug: String = title.toSlug(),
  var addedAt: LocalDateTime = LocalDateTime.now(),
  @Id @GeneratedValue var id: Long? = null
)

fun Article.render() = RenderedArticle(
  slug,
  title,
  headline,
  content,
  author,
  addedAt.format()
)
