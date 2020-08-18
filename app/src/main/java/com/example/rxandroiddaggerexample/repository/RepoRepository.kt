package com.example.rxandroiddaggerexample.repository

import com.example.rxandroiddaggerexample.db.Repo
import io.reactivex.Observable

class RepoRepository(private val remoteSource: RepoRemoteSource, private val localSource: RepoLocalSource) : RepoDataSource {
    override fun getRepos(username: String): Observable<List<Repo>> {
        // TODO: 8/18/2020 that's not right, if some repo is deleted from the server it will be returned from the database
        return Observable.concatArray(localSource.getRepos(username), remoteSource.getRepos(username))
            .doOnNext { it ->
                // TODO: 8/18/2020 check how many time doOnNext is called
                saveRepos(it)
            }

    }

    override fun saveRepos(repos: List<Repo>) {
        Observable.fromCallable { localSource.saveRepos(repos) }
    }
}