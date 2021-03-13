package com.aytdm.hellokotlin.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class User(
  var login: String,
  var firstname: String,
  var lastname: String,
  var description: String? = null,
  @Id @GeneratedValue private var id: Long? = null
)
