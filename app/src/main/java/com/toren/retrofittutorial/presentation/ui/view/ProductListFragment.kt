package com.toren.retrofittutorial.presentation.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.toren.retrofittutorial.databinding.FragmentProductListBinding
import com.toren.retrofittutorial.presentation.ui.adapter.ProductAdapter
import com.toren.retrofittutorial.presentation.ui.viewmodel.ProductListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment : Fragment() {

    private var _binding: FragmentProductListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ProductListViewModel by viewModels()
    private val productAdapter = ProductAdapter(mutableListOf())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentProductListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.productListRV.layoutManager = GridLayoutManager(context, 2)
        binding.productListRV.adapter = productAdapter
        observeData()
    }

    private fun observeData() {
        viewModel.products.observe(viewLifecycleOwner) {
            it?.let {
                productAdapter.updateProducts(it.products)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}