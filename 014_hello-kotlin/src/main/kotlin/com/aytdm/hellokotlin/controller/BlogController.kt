package com.aytdm.hellokotlin.controller

import com.aytdm.hellokotlin.config.BlogProperties
import com.aytdm.hellokotlin.domain.render
import com.aytdm.hellokotlin.repository.ArticleRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.server.ResponseStatusException

@Controller
@RequestMapping(value = ["/", "blog"])
class BlogController(
  private val articleRepository: ArticleRepository,
  private val properties: BlogProperties
) {
  @GetMapping
  fun blog(model: Model): String {
    model["title"] = properties.title
    model["banner"] = properties.banner
    model["articles"] = articleRepository.findAll().map { it.render() }
    return "blog"
  }

  @GetMapping("{slug}")
  fun article(@PathVariable slug: String, model: Model): String {
    val article = articleRepository.findBySlug(slug)
      ?.render()
      ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "This article does not exist")
    model["title"] = article.title
    model["article"] = article
    return "article"
  }
}
