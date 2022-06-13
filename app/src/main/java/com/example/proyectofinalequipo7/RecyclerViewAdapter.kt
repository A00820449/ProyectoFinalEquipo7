package com.example.proyectofinalequipo7

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinalequipo7.databinding.TodoItemBinding

class RecyclerViewAdapter(var todos : List<Todo>, val updateTodoCallback : (todo : Todo) -> Unit) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    class ViewHolder(val binding: TodoItemBinding) : RecyclerView.ViewHolder(binding.root) {}

    lateinit var  context : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = TodoItemBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.cardTitleTextView.text = todos[position].title
        holder.binding.cardBodyTextView.text = todos[position].body
        holder.binding.checkBox.isChecked = todos[position].done
        holder.binding.checkBox.setOnClickListener {
            todos[position].done = holder.binding.checkBox.isChecked
            updateTodoCallback(todos[position])
        }

    }

    override fun getItemCount(): Int {
        return todos.size
    }
}