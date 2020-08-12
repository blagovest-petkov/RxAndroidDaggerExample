package com.example.rxandroiddaggerexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.rxandroiddaggerexample.adapter.GithubRepoAdapter
import com.example.rxandroiddaggerexample.network.GithubApiClient
import com.example.rxandroiddaggerexample.viewmodel.RepoViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_stars_repos.*

class StarsReposActivity : AppCompatActivity() {
    //----------------------------------------------------------------------------------------------
    // Fields
    //----------------------------------------------------------------------------------------------
    private lateinit var adapter: GithubRepoAdapter
    private lateinit var repoViewModel: RepoViewModel

    //----------------------------------------------------------------------------------------------
    // Lifecycle
    //----------------------------------------------------------------------------------------------
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stars_repos)

        adapter = GithubRepoAdapter(this)
        rvStarsRepo.adapter = adapter
        rvStarsRepo.addItemDecoration(DividerItemDecoration(rvStarsRepo.context, DividerItemDecoration.VERTICAL))

        repoViewModel = ViewModelProviders.of(this).get(RepoViewModel::class.java)

        getStarredRepos()
        observerMyStars()
    }

    private fun getStarredRepos() {
        repoViewModel.getMyStarredRepos("mrabelwahed")
    }

    private fun observerMyStars() {
        repoViewModel.repoLiveData.observe(this, Observer {
            repos -> adapter.addData(repos)
        })
    }
}