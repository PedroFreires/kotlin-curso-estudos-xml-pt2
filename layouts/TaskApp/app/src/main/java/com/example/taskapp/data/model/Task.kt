package com.example.taskapp.data.model

import android.os.Parcelable
import com.example.taskapp.util.FirebaseHelper
import kotlinx.parcelize.Parcelize

@Parcelize
data class Task(
    var id: String = "",
    var description: String = "",
    var status: Status = Status.TODO
) : Parcelable { // Esse construtor vai gerar um id para a tarefa automaticamente sem precisar criar referencia em outros lugares
    init {
        this.id = FirebaseHelper.getDatabase().push().key ?: ""//gera id para cada nova tarefa
    }
}