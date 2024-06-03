package com.toren.retrofittutorial.presentation.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.toren.retrofittutorial.R
import com.toren.retrofittutorial.databinding.FragmentProductDetailBinding
import com.toren.retrofittutorial.domain.model.Product
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailFragment : Fragment() {

    private var _binding: FragmentProductDetailBinding? = null
    private val binding get() = _binding!!
    //private val args: ProductDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
/*
        args.productArg.let {
            loadProductDetails(it)
        }
*/
    }

    private fun loadProductDetails(product: Product) {
        binding.apply {
            Glide.with(requireContext())
                .load(product.images[0])
                .into(detailImgV)
            detailBrandTxtV.text = product.brand
            detailTitleTxtV.text = product.title
            detailRatingTxtV.text = product.rating.toString()
            detailStockTxtV.text = product.availabilityStatus
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}