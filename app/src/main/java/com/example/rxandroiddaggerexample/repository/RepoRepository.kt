package com.example.rxandroiddaggerexample.repository

import android.util.Log
import com.example.rxandroiddaggerexample.db.AppDatabase
import com.example.rxandroiddaggerexample.db.Repo
import com.example.rxandroiddaggerexample.util.Util
import io.reactivex.Observable

class RepoRepository(private val remoteSource: RepoRemoteSource, private val localSource: RepoLocalSource) : RepoDataSource {
    override fun getRepos(username: String): Observable<List<Repo>> {
        return Observable.concat(
            localSource.getRepos(username),
            remoteSource.getRepos(username).doOnNext { saveRepos(it) }.onErrorResumeNext(Observable.empty())
        )
    }

    private fun saveRepos(repos: List<Repo>) {
        Log.d(RepoRepository::class.java.simpleName, "Is on main thread ${Util.isOnMainThread()}")
        AppDatabase.getInstance()?.getRepoDao()!!.deleteAll()
        AppDatabase.getInstance()?.getRepoDao()!!.insertAll(repos)
    }
}