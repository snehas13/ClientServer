package com.learn.clientserver.presentation

import com.learn.clientserver.usecases.EditEmpDetails
import com.learn.clientserver.usecases.FetchDataFromServer
import com.learn.clientserver.usecases.GetEmpDetails

data class Interactors(
    val addAllEmp : FetchDataFromServer,
    val updateEmp : EditEmpDetails,
    val getEmpDetails: GetEmpDetails
)