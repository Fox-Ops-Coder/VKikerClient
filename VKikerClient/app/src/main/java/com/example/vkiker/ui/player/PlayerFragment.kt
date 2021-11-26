package com.example.vkiker.ui.player

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.vkiker.R
import com.example.vkiker.databinding.LobbyFragmentBinding
import com.example.vkiker.databinding.PlayerFragmentBinding
import com.google.android.material.tabs.TabLayout

class PlayerFragment : Fragment() {

    companion object {
        fun newInstance() = PlayerFragment()
    }

    private var _binding: PlayerFragmentBinding? = null;
    private val binding get() = _binding!!;

    private lateinit var viewModel: PlayerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(PlayerViewModel::class.java)
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.player_fragment, container, false);
        binding.lifecycleOwner = viewLifecycleOwner;
        binding.tabVs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }

        });
        return binding.root;
    }


}