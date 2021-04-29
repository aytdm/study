package com.aytdm.hellokotlin.repository

import com.aytdm.hellokotlin.domain.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
  fun findByLogin(login: String): User?
}
