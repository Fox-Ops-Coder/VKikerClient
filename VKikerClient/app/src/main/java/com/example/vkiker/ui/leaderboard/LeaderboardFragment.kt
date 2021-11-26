package com.example.vkiker.ui.leaderboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vkiker.NavGraphDirections
import com.example.vkiker.R
import com.example.vkiker.databinding.LeaderboardFragmentBinding
import com.foxdev.vkikermodule.context.ModuleContext
import com.foxdev.vkikermodule.net.netobjects.LeaderInfo

import com.foxdev.vkikermodule.viewmodels.LeaderboardViewModel

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
                binding.shortUserRecycler.adapter =
                    LeaderboardRecyclerAdapter(it) { t -> GoToUser(t) };
            } else {
                binding.shortUserRecycler.adapter =
                    LeaderboardRecyclerAdapter(emptyList<LeaderInfo>()){t->GoToUser(t)};
            }
        })
        ModuleContext.vKikerServer.loadLeaderBoards();
//        stupidViewModel.currentLobby.observe(viewLifecycleOwner,{
//            if(it!=null){
//
//            }
//
//        });
        //viewModel = ViewModelProvider(this).get(LeaderboardViewModel::class.java)
//        val activity = requireActivity();
//
//        val host =
//            activity.supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment;
//        host.findNavController().navigate(R.id.action_global_battleFragment);

        return binding.root;
    }

    fun GoToUser(userId: String?) {
        val activity = requireActivity();
        val host =
            activity.supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment;
        val action = NavGraphDirections.actionGlobalPlayerFragment(userId);
        host.findNavController().navigate(action);
    }


}