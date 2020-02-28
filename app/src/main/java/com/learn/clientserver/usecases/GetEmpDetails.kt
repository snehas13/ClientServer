package com.learn.clientserver.usecases

import com.learn.clientserver.data.EmpRepository

class GetEmpDetails(private val empRepository: EmpRepository) {
    suspend operator fun invoke() = empRepository.getEmpDetails()
}