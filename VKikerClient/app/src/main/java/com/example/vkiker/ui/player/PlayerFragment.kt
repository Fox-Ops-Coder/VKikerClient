package com.example.vkiker.ui.player

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.vkiker.R
import com.example.vkiker.databinding.PlayerFragmentBinding
import com.foxdev.vkikermodule.context.ModuleContext
import com.foxdev.vkikermodule.current.CurrentUser
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

        val args: PlayerFragmentArgs by navArgs();
        val storageName = getString(R.string.loginStorageName)
        val mySharedPreferences =
            requireActivity().getSharedPreferences(storageName, Context.MODE_PRIVATE);
        val user = CurrentUser(mySharedPreferences);
        val CurrentUserId = user.currentUser;


        if (args.userId == null || args.userId == CurrentUserId) {

        } else {
            ModuleContext.userViewModel.userLiveData.observe(viewLifecycleOwner) {
                if (it != null) {
                    binding.player = it;
                }

            }
            ModuleContext.userViewModel.loadUserInfo(args.userId!!);
        }

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