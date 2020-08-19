package com.example.rxandroiddaggerexample.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.rxandroiddaggerexample.R

class MainActivity : AppCompatActivity() {
    //----------------------------------------------------------------------------------------------
    // Lifecycle
    //----------------------------------------------------------------------------------------------
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openReposClickListener(view: View) {
        startActivity(Intent(applicationContext, StarsReposActivity::class.java))
    }
}

