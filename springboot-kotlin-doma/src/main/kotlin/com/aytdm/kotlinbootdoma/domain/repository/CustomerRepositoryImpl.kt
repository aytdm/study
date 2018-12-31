package com.aytdm.kotlinbootdoma.domain.repository

import com.aytdm.kotlinbootdoma.domain.dao.CustomerDao
import com.aytdm.kotlinbootdoma.domain.entity.CustomerEntity
import com.aytdm.kotlinbootdoma.domain.model.Customer
import org.springframework.stereotype.Repository

@Repository
class CustomerRepositoryImpl(private val customerDao: CustomerDao): CustomerRepository {

    override fun findAll(): List<Customer> {
        return customerDao.selectAll().map { _mapToModel(it) }
    }

    override fun findById(id: Int): Customer? {
        return customerDao.selectById(id)?.let { _mapToModel(it) }
    }

    override fun create(customer: Customer): Int {
        val domaEntity = _mapToDomaEntity(customer)
        customerDao.insert(domaEntity)
        return domaEntity.id
    }

    override fun update(customer: Customer) {
        val domaEntity = _mapToDomaEntity(customer)
        customerDao.update(domaEntity)
    }

    override fun delete(customer: Customer) {
        val domaEntity = _mapToDomaEntity(customer)
        customerDao.delete(domaEntity)
     }

    // ここでDomaのEntity（Java）をドメインのModel（Kotlin）に詰め替える
    private fun _mapToModel(domaEntity: CustomerEntity): Customer {
        return Customer(
                id = domaEntity.id,
                name = domaEntity.name,
                email = domaEntity.email
        )
    }

    // ここでドメインのModel（Kotlin）をDomaのEntity（Java）をに詰め替える
    private fun _mapToDomaEntity(customer: Customer): CustomerEntity {
        return CustomerEntity().also {
            it.id = customer.id
            it.name = customer.name
            it.email = customer.email
        }
    }
}