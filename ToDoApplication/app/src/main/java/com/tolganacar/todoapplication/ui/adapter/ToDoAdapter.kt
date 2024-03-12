package com.tolganacar.todoapplication.ui.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.tolganacar.todoapplication.data.entity.ToDos
import com.tolganacar.todoapplication.databinding.TodoItemBinding
import com.tolganacar.todoapplication.ui.viewmodel.MainpageViewModel
import com.tolganacar.todoapplication.ui.fragment.MainpageFragmentDirections
import com.tolganacar.todoapplication.utils.gecis

class ToDoAdapter(
    var mContext: Context,
    var todoList: List<ToDos>,
    var viewModel: MainpageViewModel
) : RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {

    val colors : Array<String> = arrayOf("#BF8D7DFF", "#BF5CFF75", "#BFC078AA","#BF005A80","#BFFFA2A5","#BFFF7434")

    inner class ToDoViewHolder(var binding: TodoItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val binding = TodoItemBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return ToDoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val todo = todoList.get(position)
        val t = holder.binding
        t.textViewToDoName.text = todo.name
        t.cardViewToDo.setCardBackgroundColor(Color.parseColor(colors[position % 6]))

        t.cardViewToDo.setOnClickListener {
            val gecis = MainpageFragmentDirections.todoDetailNav(todo = todo)
            Navigation.gecis(it, gecis)
        }

        t.imageViewDelete.setOnClickListener {
            Snackbar.make(
                it,
                "Are you sure you want to delete ${todo.name}?",
                Snackbar.LENGTH_SHORT
            )
                .setAction("EVET") {
                    viewModel.delete(todo.id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return todoList.size
    }
}