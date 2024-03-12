package com.tolganacar.todoapplication.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.tolganacar.todoapplication.R
import com.tolganacar.todoapplication.databinding.FragmentMainpageBinding
import com.tolganacar.todoapplication.ui.adapter.ToDoAdapter
import com.tolganacar.todoapplication.ui.viewmodel.MainpageViewModel
import com.tolganacar.todoapplication.utils.gecis
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainpageFragment : Fragment() {
    private lateinit var binding: FragmentMainpageBinding
    private lateinit var viewModel: MainpageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainpageBinding.inflate(inflater, container, false)

        viewModel.todoList.observe(viewLifecycleOwner) {
            val kisilerAdapter = ToDoAdapter(requireContext(), it, viewModel)
            binding.todosRv.adapter = kisilerAdapter
        }

        binding.todosRv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        binding.fab.setOnClickListener {
            Navigation.gecis(it,R.id.todoCreateNav)
        }

        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(newText: String): Boolean {
                viewModel.search(newText)
                return true
            }

            override fun onQueryTextChange(query: String): Boolean {
                viewModel.search(query)
                return true
            }
        })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: MainpageViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.toDosLoad()
    }
}