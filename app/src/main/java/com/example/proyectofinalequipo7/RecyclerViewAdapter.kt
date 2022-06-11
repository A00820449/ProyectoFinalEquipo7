package com.example.proyectofinalequipo7

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinalequipo7.databinding.TodoItemBinding

class RecyclerViewAdapter(var todos : List<Todo>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
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
        holder.binding.checkBox.setOnClickListener {
            if (holder.binding.checkBox.isChecked) {
                Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(context, "Not done", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}