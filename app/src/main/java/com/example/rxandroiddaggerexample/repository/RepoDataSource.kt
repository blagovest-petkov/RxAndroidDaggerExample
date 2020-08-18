package com.example.rxandroiddaggerexample.repository

import com.example.rxandroiddaggerexample.db.Repo
import io.reactivex.Observable

interface RepoDataSource {
    fun getRepos(username:String) : Observable<List<Repo>>

    fun saveRepos(repos: List<Repo>)
}