package com.example.rxandroiddaggerexample

import android.app.Application

class BaseApplication : Application() {
    companion object {
        private lateinit var instance: BaseApplication
        fun getInstance() = instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}