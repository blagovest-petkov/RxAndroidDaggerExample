package com.example.rxandroiddaggerexample.repository

import com.example.rxandroiddaggerexample.db.Repo
import com.example.rxandroiddaggerexample.network.GithubApiClient
import io.reactivex.Observable

object RepoRemoteSource : RepoDataSource {
    override fun getRepos(username: String): Observable<List<Repo>> {
        return GithubApiClient.githubService.getStarredRepos(username)
    }

    override fun saveRepos(repos: List<Repo>) {
    }
}