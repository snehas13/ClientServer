package com.learn.clientserver.data

import com.learn.clientserver.domain.Success

class EmpRepository(private val empDataSource: EmpDataSource) {

    suspend fun AddEmployee(empData : Success) = empDataSource.add(empData)

    suspend fun EditEmployee(empData : Success) = empDataSource.edit(empData)

    suspend fun getEmpDetails() = empDataSource.readAll()
}