package com.aytdm.hellobigquery.service

import com.aytdm.hellobigquery.domain.User
import com.google.cloud.bigquery.BigQuery
import com.google.cloud.bigquery.QueryJobConfiguration
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class UserService(private val bigQuery: BigQuery) {
  @Value("\${spring.cloud.gcp.bigquery.dataset-name}")
  lateinit var datasetName: String

  fun findById(userId: Long): User? {
    val query = String.format("SELECT id FROM %s.user where id = %d;", datasetName, userId)
    val queryConfig = QueryJobConfiguration.newBuilder(query).build()
    var user: User? = null

    bigQuery.query(queryConfig).iterateAll()?.let {
      for (row in it) {
        for (`val` in row) {
          user = User(id = `val`.value as String)
        }
      }
    }

    return user
  }
}
