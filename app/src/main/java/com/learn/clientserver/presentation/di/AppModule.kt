package com.learn.clientserver.presentation.di

import com.learn.clientserver.data.EmpDataSourceImpl
import com.learn.clientserver.data.EmpRepository
import com.learn.clientserver.usecases.EditEmpDetails
import com.learn.clientserver.usecases.FetchDataFromServer
import com.learn.clientserver.usecases.GetEmpDetails
import com.learn.clientserver.presentation.Interactors
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val repoModule = module {
    single {
        EmpRepository(EmpDataSourceImpl(androidContext())) as EmpRepository
    }
}

val interactorsModule = module {
    single<Interactors> {
        Interactors(
            FetchDataFromServer(empRepository = get()),
            EditEmpDetails(empRepository = get()),
            GetEmpDetails(empRepository = get())
        )
    }
}