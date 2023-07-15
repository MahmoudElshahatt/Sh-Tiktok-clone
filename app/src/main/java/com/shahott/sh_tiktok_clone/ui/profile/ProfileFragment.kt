package com.shahott.sh_tiktok_clone.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.shahott.sh_tiktok_clone.R
import com.shahott.sh_tiktok_clone.databinding.FragmentHomeBinding
import com.shahott.sh_tiktok_clone.databinding.FragmentProfileBinding
import com.shahott.sh_tiktok_clone.ui.home.HomeViewModel

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var pagerAdapter: FragmentPageAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickListeners()
        setUpViewPager()
        toggleTabs()
    }

    private fun onClickListeners() {

    }

    private fun setUpViewPager() {
        pagerAdapter = FragmentPageAdapter(childFragmentManager, lifecycle)
//        binding.tebLayout.apply {
//            addTab(newTab().setIcon(R.drawable.ic_grid))
//            addTab(newTab().setIcon(R.drawable.ic_hearts))
//        }
        binding.viewpager.adapter = pagerAdapter
    }

    private fun toggleTabs() {
        binding.apply {
            tebLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    binding.viewpager.currentItem = tab?.position ?: 0
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {}
                override fun onTabReselected(tab: TabLayout.Tab?) {}
            })
            viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.tebLayout.selectTab(binding.tebLayout.getTabAt(position))
                }
            })
        }
    }
}


