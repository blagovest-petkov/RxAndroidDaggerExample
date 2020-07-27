package com.example.rxandroiddaggerexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rxandroiddaggerexample.adapter.GithubRepoAdapter
import com.example.rxandroiddaggerexample.model.Repo
import com.example.rxandroiddaggerexample.network.GithubApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_stars_repos.*

class StarsReposActivity : AppCompatActivity() {
    //----------------------------------------------------------------------------------------------
    // Fields
    //----------------------------------------------------------------------------------------------
    private lateinit var adapter:GithubRepoAdapter;

    //----------------------------------------------------------------------------------------------
    // Lifecycle
    //----------------------------------------------------------------------------------------------
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stars_repos)

        adapter = GithubRepoAdapter()
        rvStarsRepo.adapter = adapter

        getStarredRepos()
    }

    fun getStarredRepos() {
        GithubApiClient.githubService.getStarredRepos("mrabelwahed")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                it -> adapter.addData(it)
            }

    }

}