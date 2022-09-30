package com.example.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.FullFoodFragmentBinding
import com.example.app.models.Food
import kotlinx.coroutines.launch

class FullFoodFragment : Fragment() {

    private val foodViewModel by activityViewModels<FoodViewModel> {
        FoodViewModelFactory(
            (activity?.application as FoodApplication).database.foodDao()
        )
    }

    private var _binding: FullFoodFragmentBinding?=null

    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView

    private lateinit var adapter: FoodAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FullFoodFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        if (::adapter.isInitialized) {
            recyclerView.adapter = adapter
            lifecycle.coroutineScope.launch {
                foodViewModel.fullFood().collect() {
                    adapter.submitList(it)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}