package com.learn.clientserver.usecases

import com.learn.clientserver.data.EmpRepository
import com.learn.clientserver.domain.Success

class FetchDataFromServer(private val empRepository: EmpRepository) {

    suspend operator fun invoke(empList : List<Success>) {1
        for(empData in empList) {
            empRepository.AddEmployee(empData)
        }
    }
}