package com.example.vkiker.ui.leaderboard

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.vkiker.R
import com.example.vkiker.databinding.LeaderboardFragmentBinding

class LeaderboardFragment : Fragment() {

    companion object {
        fun newInstance() = LeaderboardFragment()
    }

    private var _binding: LeaderboardFragmentBinding? = null;
    private val binding get() = _binding!!;
    private lateinit var viewModel: LeaderboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.leaderboard_fragment, container, false);
        binding.lifecycleOwner = viewLifecycleOwner;
        viewModel = ViewModelProvider(this).get(LeaderboardViewModel::class.java)

        return binding.root;
    }


}