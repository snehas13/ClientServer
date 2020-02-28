package com.learn.clientserver.usecases

import com.learn.clientserver.data.EmpRepository
import com.learn.clientserver.domain.Success

class EditEmpDetails (private val empRepository: EmpRepository) {
    suspend operator fun invoke(empData: Success) = empRepository.EditEmployee(empData)
}