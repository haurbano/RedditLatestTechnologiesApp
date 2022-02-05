package com.haur.daviget

import android.app.Application
import com.haur.data.di.dataModule
import com.haur.domain.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RedditApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@RedditApp)
            modules(domainModule, dataModule)
        }
    }
}