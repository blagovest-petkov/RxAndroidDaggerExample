package com.example.rxandroiddaggerexample.db

import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.rxandroiddaggerexample.BaseApplication

@Database(entities = [Repo::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        private var instance: AppDatabase? = null
            fun getInstance(): AppDatabase? {
                return instance?.let { instance }?:run {
                    instance = Room.databaseBuilder(BaseApplication.getInstance(), AppDatabase::class.java, "main.db").build()
                    return instance
                }
            }
    }

    override fun createOpenHelper(config: DatabaseConfiguration?): SupportSQLiteOpenHelper {
        TODO("Not yet implemented")
    }

    override fun createInvalidationTracker(): InvalidationTracker {
        TODO("Not yet implemented")
    }

    override fun clearAllTables() {
        TODO("Not yet implemented")
    }

    abstract fun getRepoDao(): RepoDao
}