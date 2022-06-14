package com.example.proyectofinalequipo7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectofinalequipo7.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch
import java.util.*

class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AppViewModel by activityViewModels {
        AppViewModelFactory(
            (activity?.application as TodoApp).database.todoDao()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            val today = Date()

            val adapter = RecyclerViewAdapter(viewModel.getTodosDueBefore(today).toMutableList(), { todo : Todo -> updateTodoCallback(todo) }, { id : Int -> deleteTodoCallback(id)})
            binding.listRecyclerView.adapter = adapter
            binding.listRecyclerView.layoutManager = LinearLayoutManager(activity)

            val adapter2 = RecyclerViewAdapter(viewModel.getTodosDueAfter(today).toMutableList(), { todo : Todo -> updateTodoCallback(todo) }, { id : Int -> deleteTodoCallback(id)})
            binding.list2RecyclerView.adapter = adapter2
            binding.list2RecyclerView.layoutManager = LinearLayoutManager(activity)

            val adapter3 = RecyclerViewAdapter(viewModel.getTodosNoDue().toMutableList(), { todo : Todo -> updateTodoCallback(todo) }, { id : Int -> deleteTodoCallback(id)})
            binding.list3RecyclerView.adapter = adapter3
            binding.list3RecyclerView.layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun updateTodoCallback(todo : Todo) {
        lifecycleScope.launch {
            viewModel.updateTodo(todo)
        }
    }

    private fun deleteTodoCallback(id: Int) {
        lifecycleScope.launch {
            viewModel.deleteTodo(id)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}