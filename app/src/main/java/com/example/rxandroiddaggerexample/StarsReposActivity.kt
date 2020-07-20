package com.example.rxandroiddaggerexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rxandroiddaggerexample.adapter.GithubRepoAdapter
import com.example.rxandroiddaggerexample.model.Repo
import kotlinx.android.synthetic.main.activity_stars_repos.*

class StarsReposActivity : AppCompatActivity() {
    //----------------------------------------------------------------------------------------------
    // Fields
    //----------------------------------------------------------------------------------------------
    private val repoList:ArrayList<Repo> = ArrayList()

    //----------------------------------------------------------------------------------------------
    // Lifecycle
    //----------------------------------------------------------------------------------------------
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stars_repos)

        val adapter = GithubRepoAdapter()

        repoList.add(Repo("RxJava", "Rx Java for android", "Java"))
        repoList.add(Repo("RxJava", "Rx Java for android", "Java"))
        repoList.add(Repo("RxJava", "Rx Java for android", "Java"))
        repoList.add(Repo("RxJava", "Rx Java for android", "Java"))
        repoList.add(Repo("RxJava", "Rx Java for android", "Java"))
        repoList.add(Repo("RxJava", "Rx Java for android", "Java"))
        repoList.add(Repo("RxJava", "Rx Java for android", "Java"))
        repoList.add(Repo("RxJava", "Rx Java for android", "Java"))
        repoList.add(Repo("RxJava", "Rx Java for android", "Java"))
        repoList.add(Repo("RxJava", "Rx Java for android", "Java"))

        adapter.addData(repoList)
        rvStarsRepo.adapter = adapter
    }
}