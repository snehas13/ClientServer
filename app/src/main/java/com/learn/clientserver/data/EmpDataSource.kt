package com.learn.clientserver.data

import com.learn.clientserver.domain.Success

interface EmpDataSource {
    suspend fun add(empList : Success)
    suspend fun readAll() : List<Success>
    suspend fun edit(empData: Success)
}