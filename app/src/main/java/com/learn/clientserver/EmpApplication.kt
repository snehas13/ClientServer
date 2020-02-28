package com.learn.clientserver

import android.app.Application
import com.learn.clientserver.presentation.di.interactorsModule
import com.learn.clientserver.presentation.di.repoModule
import org.koin.android.ext.android.startKoin

class EmpApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(repoModule,interactorsModule))
    }
}