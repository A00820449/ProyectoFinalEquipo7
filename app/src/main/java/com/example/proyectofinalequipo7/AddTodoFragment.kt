package com.example.proyectofinalequipo7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.proyectofinalequipo7.databinding.FragmentAddTodoBinding
import java.lang.Exception
import java.util.*

class AddTodoFragment : Fragment() {

    private val viewModel : AppViewModel by activityViewModels()
    private var _binding : FragmentAddTodoBinding? = null
    private val binding get() = _binding!!
    private lateinit var successToast : Toast

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddTodoBinding.inflate(inflater, container, false)
        successToast = Toast.makeText(activity, "Success", Toast.LENGTH_SHORT)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addButton.setOnClickListener {
            
            val title = binding.titleEditText.text.toString()

            if (title == "") {
                // failToast.cancel()
                // failToast.show()
                return@setOnClickListener
            }

            val body = if (binding.bodyEditText.text.toString() == "") { null } else { binding.bodyEditText.text.toString() }

            var unix : Long? = try {
                binding.dueDateEditText.text.toString().toLong()
            } catch (e : Exception) {
                null
            }

            val dueDate = if (unix == null) { null } else { Date(unix) }

            viewModel.addTodo(title, body, dueDate)

            binding.titleEditText.text.clear()
            binding.bodyEditText.text.clear()
            binding.dueDateEditText.text.clear()

            successToast.cancel()
            successToast.show()
        }
    }

}