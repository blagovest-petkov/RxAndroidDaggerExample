package com.example.rxandroiddaggerexample

import android.os.Bundle
import android.support.wearable.activity.WearableActivity

class MyStarsRepos : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_stars_repos)

        // Enables Always-on
        setAmbientEnabled()
    }
}