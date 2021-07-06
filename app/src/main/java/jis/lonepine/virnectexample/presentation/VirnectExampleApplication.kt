package jis.lonepine.virnectexample.presentation

import androidx.multidex.MultiDexApplication
import jis.lonepine.virnectexample.presentation.di.moduleList
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class VirnectExampleApplication: MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@VirnectExampleApplication)
            modules(moduleList)
        }
    }
}