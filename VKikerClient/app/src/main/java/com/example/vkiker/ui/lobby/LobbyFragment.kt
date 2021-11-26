package com.example.vkiker.ui.lobby

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.vkiker.R
import com.example.vkiker.databinding.LeaderboardFragmentBinding
import com.example.vkiker.databinding.LobbyFragmentBinding

class LobbyFragment : Fragment() {

    companion object {
        fun newInstance() = LobbyFragment()
    }

    //private lateinit var viewModel: LobbyViewModel
    private var _binding: LobbyFragmentBinding ? = null;
    private val binding get() = _binding!!;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.lobby_fragment, container, false);
        binding.lifecycleOwner = viewLifecycleOwner;

        return binding.root;
        //viewModel = ViewModelProvider(this).get(LobbyViewModel::class.java)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // TODO: Use the ViewModel
    }

}