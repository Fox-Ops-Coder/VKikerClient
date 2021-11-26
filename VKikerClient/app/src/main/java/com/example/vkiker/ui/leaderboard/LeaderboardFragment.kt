package com.example.vkiker.ui.leaderboard

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vkiker.R
import com.example.vkiker.databinding.LeaderboardFragmentBinding
import com.foxdev.vkikermodule.context.ModuleContext
import com.foxdev.vkikermodule.objects.ShortUser
import com.foxdev.vkikermodule.viewmodels.LeaderboardViewModel
import com.foxdev.vkikermodule.viewmodels.UserViewModel

class LeaderboardFragment : Fragment() {

    companion object {
        fun newInstance() = LeaderboardFragment()
    }

    private var _binding: LeaderboardFragmentBinding? = null;
    private val binding get() = _binding!!;

    private lateinit var stupidViewModel: LeaderboardViewModel;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.leaderboard_fragment, container, false);
        binding.lifecycleOwner = viewLifecycleOwner;
        binding.shortUserRecycler.layoutManager = LinearLayoutManager(requireContext());
        stupidViewModel = ModuleContext.leaderboardViewModel;
        stupidViewModel.leaders.observe(viewLifecycleOwner, {
            if (it != null) {
                binding.shortUserRecycler.adapter = LeaderboardRecyclerAdapter(it);
            } else {
                binding.shortUserRecycler.adapter =
                    LeaderboardRecyclerAdapter(emptyList<ShortUser>());
            }
        })
        ModuleContext.vKikerServer.loadLeaderboards();

//        stupidViewModel.currentLobby.observe(viewLifecycleOwner,{
//            if(it!=null){
//
//            }
//
//        });
        //viewModel = ViewModelProvider(this).get(LeaderboardViewModel::class.java)

        return binding.root;
    }


}