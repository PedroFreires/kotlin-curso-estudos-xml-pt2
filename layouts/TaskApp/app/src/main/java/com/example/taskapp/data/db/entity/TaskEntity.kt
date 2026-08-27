package com.example.taskapp.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

import com.example.taskapp.data.model.Status
import com.example.taskapp.data.model.Task

@Entity(tableName = "task_table")
class TaskEntity(
    @PrimaryKey(autoGenerate = true) //Auto incremento para o id
    val id: Long = 0,

//    @ColumnInfo(name = "descrip") Se eu quisesse alterar um outro no para a coluna do db
    val description: String,

    val status: Status
)

fun Task.toTaskEntity(): TaskEntity {
    return with(this) {
        TaskEntity(
            id = this.id,
            description = this.description,
            status = this.status
        )
    }
}