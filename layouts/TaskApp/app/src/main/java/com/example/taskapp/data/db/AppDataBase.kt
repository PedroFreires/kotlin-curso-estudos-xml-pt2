package com.example.taskapp.data.db

import android.content.Context
import androidx.room3.Database
import androidx.room3.Room
import androidx.room3.RoomDatabase
import com.example.taskapp.data.db.dao.TaskDao
import com.example.taskapp.data.db.entity.TaskEntity

@Database(entities = [TaskEntity::class], version = 1)
public abstract class AppDataBase : RoomDatabase() {

abstract fun TaskDao(): TaskDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "task_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}