package com.aytdm.hellokotlin.domain

data class RenderedArticle(
  val slug: String,
  val title: String,
  val headline: String,
  val content: String,
  val author: User,
  val addedAt: String
)
