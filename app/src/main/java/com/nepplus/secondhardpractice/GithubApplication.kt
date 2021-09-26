package com.nepplus.secondhardpractice

import android.app.Application
import com.nepplus.secondhardpractice.di.applicationModule
import org.koin.core.context.startKoin

class GithubApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(applicationModule)
        }
    }
}