package com.example.proyectofinalequipo7

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.text.set
import androidx.fragment.app.activityViewModels
import com.example.proyectofinalequipo7.databinding.FragmentAddTodoBinding
import java.lang.Exception
import java.time.LocalDate
import java.util.*

class AddTodoFragment : Fragment() {

    private val viewModel : AppViewModel by activityViewModels()
    private var _binding : FragmentAddTodoBinding? = null
    private val binding get() = _binding!!
    private lateinit var successToast : Toast
    private lateinit var failToast : Toast

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddTodoBinding.inflate(inflater, container, false)
        successToast = Toast.makeText(activity, "Success", Toast.LENGTH_SHORT)
        failToast = Toast.makeText(activity, "Missing title", Toast.LENGTH_SHORT)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var dueDate : Date? = null
        var title = ""
        var body : String? = null

        binding.dueDateEditText.setOnClickListener{

            fun onDateSelected(day: Int, month: Int, year: Int) {
                val c = Calendar.getInstance()
                c.set(Calendar.YEAR, year)
                c.set(Calendar.MONTH, month)
                c.set(Calendar.DAY_OF_MONTH, day)

                dueDate = c.time
                binding.dueDateEditText.setText("$day/$month/$year")
            }

            val datePicker = DatePickerFragment { day, month, year -> onDateSelected(day, month, year) }
            datePicker.show(parentFragmentManager, "datePicker")

        }

        binding.addButton.setOnClickListener {
            
            title = binding.titleEditText.text.toString().trim()

            if (title == "") {
                failToast.cancel()
                failToast.show()
                return@setOnClickListener
            }

            body = if (binding.bodyEditText.text.toString().trim() == "") {
                null
            } else {
                binding.bodyEditText.text.toString().trim()
            }

            viewModel.addTodo(title, body, dueDate)

            binding.titleEditText.text.clear()
            binding.bodyEditText.text.clear()
            binding.dueDateEditText.text.clear()

            successToast.cancel()
            successToast.show()
        }
    }

}