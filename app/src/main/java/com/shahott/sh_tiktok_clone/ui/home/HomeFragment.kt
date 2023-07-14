package com.shahott.sh_tiktok_clone.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.shahott.sh_tiktok_clone.MainActivity
import com.shahott.sh_tiktok_clone.R
import com.shahott.sh_tiktok_clone.databinding.FragmentHomeBinding
import com.shahott.sh_tiktok_clone.ui.home.adapters.TikTokVideosAdapter
import com.shahott.sh_tiktok_clone.util.showContentAboveStatusBar

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding
    private lateinit var tiktokAdapter: TikTokVideosAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentHomeBinding.inflate(layoutInflater)
        (activity as MainActivity).bottomNavigationVisibility(false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().showContentAboveStatusBar()
        setupReels()
    }

    private fun setupReels() {
        tiktokAdapter = TikTokVideosAdapter(viewModel.getTikTokVideos())
        binding.viewPager.adapter = tiktokAdapter
    }



}