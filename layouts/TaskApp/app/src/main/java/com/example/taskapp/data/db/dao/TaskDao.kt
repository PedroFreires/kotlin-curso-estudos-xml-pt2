package com.example.taskapp.data.db.dao

import androidx.room3.Dao
import androidx.room3.Entity
import androidx.room3.Insert
import androidx.room3.OnConflictStrategy.Companion.IGNORE
import androidx.room3.Query
import com.example.taskapp.data.model.Status
import com.example.taskapp.data.model.Task

@Dao
interface TaskDao {

    @Query("SELECT * FROM task_table ORDER BY id DESC")
    suspend fun getAllTask(): List<Task>

    @Insert(onConflict = IGNORE)
    suspend fun insertTask(taskEntity: Entity): Long

    @Query("DELETE FROM task_table WHERE id = :id")
    suspend fun deleteTask(id: Long)

    @Query("UPDATE task_table SET description = :description, status = :status WHERE id = :id")
    suspend fun updateTask(
        id: Long,
        description: String,
        status: Status
    )
}