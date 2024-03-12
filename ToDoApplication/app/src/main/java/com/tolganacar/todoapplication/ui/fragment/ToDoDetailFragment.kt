package com.tolganacar.todoapplication.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.tolganacar.todoapplication.R
import com.tolganacar.todoapplication.databinding.FragmentToDoDetailBinding
import com.tolganacar.todoapplication.ui.viewmodel.ToDoDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ToDoDetailFragment : Fragment() {
    private lateinit var binding: FragmentToDoDetailBinding
    private lateinit var viewModel: ToDoDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentToDoDetailBinding.inflate(inflater, container, false)

        val bundle: ToDoDetailFragmentArgs by navArgs()
        val todoDetail = bundle.todo

        binding.editTextToDoName.setText(todoDetail.name)

        binding.buttonUpdate.setOnClickListener {
            val name = binding.editTextToDoName.text.toString()
            viewModel.update(todoDetail.id, name)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: ToDoDetailViewModel by viewModels()
        viewModel = tempViewModel
    }
}