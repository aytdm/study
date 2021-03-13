package com.aytdm.hellokotlin

import com.aytdm.hellokotlin.config.BlogProperties
import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(BlogProperties::class)
class HelloKotlinApplication

fun main(args: Array<String>) {
  runApplication<HelloKotlinApplication>(*args) {
    setBannerMode(Banner.Mode.OFF)
  }
}
