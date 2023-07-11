package com.shahott.sh_tiktok_clone.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shahott.sh_tiktok_clone.MainActivity
import com.shahott.sh_tiktok_clone.R
import com.shahott.sh_tiktok_clone.util.showContentAboveStatusBar

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as MainActivity).bottomNavigationVisibility(true)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().showContentAboveStatusBar()
    }


}