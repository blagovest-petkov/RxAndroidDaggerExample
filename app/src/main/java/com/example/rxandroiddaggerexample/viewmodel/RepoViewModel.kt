package com.example.rxandroiddaggerexample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rxandroiddaggerexample.model.Repo
import com.example.rxandroiddaggerexample.network.GithubApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class RepoViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val repoLiveData = MutableLiveData<List<Repo>>()

    fun getMyStarredRepos(username: String) {
        val repoDisposable: Disposable = GithubApiClient.githubService.getStarredRepos(username)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { it -> repoLiveData.value = it }

        compositeDisposable.add(repoDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}