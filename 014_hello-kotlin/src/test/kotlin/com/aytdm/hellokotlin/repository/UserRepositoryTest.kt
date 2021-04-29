package com.aytdm.hellokotlin.repository

import com.aytdm.hellokotlin.domain.User
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class UserRepositoryTest @Autowired constructor(
  val entityManager: TestEntityManager,
  val userRepository: UserRepository
) {

  @Test
  fun `When findByLogin then return User`() {
    val juergen = User("springjuergen", "Juergen", "Hoeller")
    entityManager.persist(juergen)
    entityManager.flush()
    val user = userRepository.findByLogin(juergen.login)
    assertThat(user).isEqualTo(juergen)
  }
}
