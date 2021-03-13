package com.aytdm.hellokotlin.repository

import com.aytdm.hellokotlin.domain.Article
import org.springframework.data.repository.CrudRepository

interface ArticleRepository : CrudRepository<Article, Long> {
  fun findBySlug(slug: String): Article?
  fun findAllByOrderByAddedAtDesc(): Iterable<Article>
}
