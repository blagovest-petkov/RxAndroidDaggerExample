package com.example.rxandroiddaggerexample.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Observable

@Dao
interface RepoDao {

    @Query("SELECT * FROM repo")
    fun getAll(): List<Repo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(repos: List<Repo>)
}