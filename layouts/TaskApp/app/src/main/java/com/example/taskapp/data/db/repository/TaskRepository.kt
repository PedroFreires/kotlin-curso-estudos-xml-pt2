package com.example.taskapp.data.db.repository

import androidx.room3.Entity
import com.example.taskapp.data.db.dao.TaskDao
import com.example.taskapp.data.db.entity.TaskEntity
import com.example.taskapp.data.model.Task

class TaskRepository(private val  taskDao: TaskDao) {

    suspend fun getAllTask(): List<Task> {
        return taskDao.getAllTask()
    }

    suspend fun insertTask(taskEntity: Entity): Long {
        return taskDao.insertTask(taskEntity)
    }

    suspend fun deleteTask(id: Long) = taskDao.deleteTask(id)

    suspend fun updateTask(taskEntity: TaskEntity) {
        taskDao.updateTask(
            id = taskEntity.id,
            description = taskEntity.description,
            status = taskEntity.status
        )
    }
}