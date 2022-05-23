package com.example.proyectofinalequipo7

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinalequipo7.databinding.TodoItemBinding

class RecyclerViewAdapter(var todos : List<Todo>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    class ViewHolder(val binding: TodoItemBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = TodoItemBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.cardTitleTextView.text = todos[position].title
        holder.binding.cardBodyTextView.text = todos[position].body
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}