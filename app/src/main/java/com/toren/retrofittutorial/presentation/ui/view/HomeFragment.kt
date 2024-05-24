package com.toren.retrofittutorial.presentation.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.toren.retrofittutorial.databinding.FragmentHomeBinding
import com.toren.retrofittutorial.presentation.ui.adapter.HomeFragmentStateAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: HomeFragmentStateAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewPagerAdapter()
    }


    private val fragmentList = arrayListOf(ProductListFragment(), SearchFragment())

    private val tabTitles = arrayListOf("Home","Search")

    private fun initViewPagerAdapter(){
        val viewPager = binding.homeFragmentViewPager
        adapter = HomeFragmentStateAdapter(childFragmentManager, viewLifecycleOwner.lifecycle,fragmentList)
        viewPager.adapter = adapter

        TabLayoutMediator(binding.homeFragmentTableLayout, viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}