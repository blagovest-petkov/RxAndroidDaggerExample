package com.example.rxandroiddaggerexample.network

import com.example.rxandroiddaggerexample.model.Repo
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    @GET("users/{user}/starred")
    fun getStarredRepos(@Path("user") userName:String):Observable<List<Repo>>
}