package com.example.rxandroiddaggerexample.repository

import com.example.rxandroiddaggerexample.db.AppDatabase
import com.example.rxandroiddaggerexample.db.Repo
import io.reactivex.Observable

object RepoLocalSource : RepoDataSource {
    override fun getRepos(username: String): Observable<List<Repo>> {
        return Observable.fromCallable { AppDatabase.getInstance()?.getRepoDao()!!.getAll() }
    }
}