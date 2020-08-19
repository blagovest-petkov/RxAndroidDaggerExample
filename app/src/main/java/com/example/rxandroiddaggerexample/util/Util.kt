package com.example.rxandroiddaggerexample.util

import android.os.Looper

object Util {
    fun isOnMainThread() : Boolean {
        return Looper.myLooper() == Looper.getMainLooper()
    }
}