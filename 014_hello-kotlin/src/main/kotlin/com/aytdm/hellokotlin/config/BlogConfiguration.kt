package com.aytdm.hellokotlin.config

import com.aytdm.hellokotlin.domain.Article
import com.aytdm.hellokotlin.domain.User
import com.aytdm.hellokotlin.repository.ArticleRepository
import com.aytdm.hellokotlin.repository.UserRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {
  @Bean
  fun databaseInitialize(userRepository: UserRepository, articleRepository: ArticleRepository) = ApplicationRunner {
    val smaldini = userRepository.save(
      User(
        "smaldini",
        "Stephane",
        "Maldini"
      )
    )
    articleRepository.save(
      Article(
        title = "Reactor Bismuth is out",
        headline = "Lorem ipsum",
        content = "dolor sit amet",
        author = smaldini
      )
    )
    articleRepository.save(
      Article(
        title = "Reactor Aluminium has landed",
        headline = "Lorem ipsum",
        content = "dolor sit amet",
        author = smaldini
      )
    )
  }
}
