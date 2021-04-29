package com.aytdm.kotlinbootdoma.domain.service

import com.aytdm.kotlinbootdoma.app.exception.Exception
import com.aytdm.kotlinbootdoma.app.form.CustomerForm
import com.aytdm.kotlinbootdoma.domain.model.Customer
import com.aytdm.kotlinbootdoma.domain.repository.CustomerRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CustomerService(private val customerRepository: CustomerRepository) {
    fun create(customerForm: CustomerForm): Int {
        val customer = Customer(
                name = customerForm.name!!,
                email = customerForm.email!!
        )

        return customerRepository.create(customer)
    }

    fun findAll(): List<Customer> {
        return customerRepository.findAll()
    }

    fun findById(id: Int): Customer {
        return customerRepository.findById(id) ?: throw Exception()
    }

    fun update(id: Int, customerForm: CustomerForm) {
        val existingCustomer = customerRepository.findById(id) ?: throw Exception()

        val customer = existingCustomer.copy(
              name = customerForm.name!!,
              email = customerForm.email!!
        )

        customerRepository.update(customer)
    }

    fun delete(id: Int) {
        val customer = customerRepository.findById(id) ?: throw Exception()
        customerRepository.delete(customer)
    }
}