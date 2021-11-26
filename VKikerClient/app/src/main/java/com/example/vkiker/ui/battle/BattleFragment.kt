package com.example.vkiker.ui.battle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.vkiker.R
import com.example.vkiker.databinding.FragmentBattleBinding
import com.example.vkiker.databinding.LeaderboardFragmentBinding


class BattleFragment : Fragment() {

    private var _binding: FragmentBattleBinding? = null;
    private val binding get() = _binding!!;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_battle, container, false);
        binding.lifecycleOwner = viewLifecycleOwner;

        return binding.root;
    }


}