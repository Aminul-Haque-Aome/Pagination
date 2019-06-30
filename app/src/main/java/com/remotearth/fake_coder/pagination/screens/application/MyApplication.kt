package com.remotearth.fake_coder.pagination.screens.application

import android.app.Application
import com.remotearth.fake_coder.pagination.BuildConfig
import com.remotearth.fake_coder.pagination.utils.ReleaseTree
import timber.log.Timber

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initLogger()
    }

    private fun initLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                override
                fun createStackElementTag(element: StackTraceElement): String? {
                    return String.format("Class:%s: Line: %s, Method: %s", super.createStackElementTag(element), element.lineNumber, element.methodName)
                }
            })
        } else {
//            Fabric.with(this, Crashlytics(), Answers())
            Timber.plant(ReleaseTree())
        }
    }
}