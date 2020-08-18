package com.example.rxandroiddaggerexample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rxandroiddaggerexample.db.Repo
import com.example.rxandroiddaggerexample.repository.RepoLocalSource
import com.example.rxandroiddaggerexample.repository.RepoRemoteSource
import com.example.rxandroiddaggerexample.repository.RepoRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class RepoViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val repository = RepoRepository(RepoRemoteSource, RepoLocalSource)

    val repoLiveData = MutableLiveData<List<Repo>>()

    fun getMyStarredRepos(username: String) {
        val repoDisposable: Disposable = repository.getRepos(username)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { repoLiveData.value = it }

        compositeDisposable.add(repoDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}