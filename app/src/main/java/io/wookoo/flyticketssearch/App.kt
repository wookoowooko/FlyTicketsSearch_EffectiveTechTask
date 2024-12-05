package io.wookoo.flyticketssearch

import android.app.Application
import io.wookoo.flyticketssearch.all.tickets.di.allTicketsModule
import io.wookoo.flyticketssearch.data.di.dataModule
import io.wookoo.flyticketssearch.search.results.di.searchResultModule
import io.wookoo.flyticketssearch.tickets.di.ticketsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            androidLogger(Level.DEBUG)
            modules(dataModule + ticketsModule + searchResultModule + allTicketsModule)
        }
    }
}
