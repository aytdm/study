package com.aytdm.hellobigquery.controller

import com.aytdm.hellobigquery.domain.User
import com.aytdm.hellobigquery.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("user")
class UserController(private val userService: UserService) {
  @GetMapping("{userId}")
  fun user(@PathVariable userId: Long): User? {
    return userService.findById(userId)
  }
}
