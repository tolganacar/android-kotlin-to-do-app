package com.tolganacar.todoapplication.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.tolganacar.todoapplication.R
import com.tolganacar.todoapplication.databinding.FragmentToDoCreateBinding
import com.tolganacar.todoapplication.ui.viewmodel.ToDoCreateViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ToDoCreateFragment : Fragment() {
    private lateinit var binding: FragmentToDoCreateBinding
    private lateinit var viewModel: ToDoCreateViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentToDoCreateBinding.inflate(inflater, container, false)

        binding.buttonCreate.setOnClickListener {
            val name = binding.editTextToDoName.text.toString()
            viewModel.create(name)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: ToDoCreateViewModel by viewModels()
        viewModel = tempViewModel
    }
}