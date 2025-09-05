package com.example.taskapp.ui.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.taskapp.R
import com.example.taskapp.data.model.Status
import com.example.taskapp.data.model.Status.*
import com.example.taskapp.data.model.Task
import com.example.taskapp.databinding.ItemTaskBinding

class TaskAdapter(
    private val context: Context,
    private val taskList: List<Task>,
    private val taskSelected:(Task, Int) -> Unit
) : RecyclerView.Adapter<TaskAdapter.MyViewHolder>() {

    //Eventos de clique que podemos ter em cada Task
    companion object{
        val SELECT BACK: Int = 1
        val SELECT REMOVE: Int = 2
        val SELECT EDIT: Int = 3
        val SELECT DETAILS: Int = 4
        val SELECT NEXT: Int = 5
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val task = taskList[position]

        holder.binding.textDescription.text = task.description

        setIndicators(task, holder)


    }

    private fun setIndicators(task: Task, holder: MyViewHolder) {
        when (task.status) {
            TODO -> {
                holder.binding.btnBack.isVisible = false

                holder.binding.btnDelete.setOnClickListener { taskSelected }
            }

            DOING -> {
                holder.binding.btnBack.setColorFilter(
                    ContextCompat.getColor(
                        context,
                        R.color.color_status_todo
                    )
                )

                holder.binding.btnNext.setColorFilter(
                    ContextCompat.getColor(
                        context,
                        R.color.color_status_done
                    )
                )
            }

            DONE -> {
                holder.binding.btnNext.isVisible = false
            }
        }
    }

    override fun getItemCount() = taskList.size

    //inner class é porque estou usando essa classe internamente (somente aqui)
    inner class MyViewHolder(val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root)
}