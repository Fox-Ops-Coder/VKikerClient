package com.example.vkiker.ui.player

import android.content.Context
import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.vkiker.R
import com.example.vkiker.connection.BattleStates
import com.example.vkiker.databinding.PlayerFragmentBinding
import com.foxdev.vkikermodule.context.ModuleContext
import com.foxdev.vkikermodule.current.CurrentUser
import com.foxdev.vkikermodule.net.VKikerServer
import com.foxdev.vkikermodule.net.netobjects.DuelInvitation
import com.google.android.material.tabs.TabLayout
import java.util.function.Consumer

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

            binding.challengeToDuel.visibility = View.GONE;
            binding.ChallengeToSimpleBattle.visibility = View.GONE;
        }
        ModuleContext.userViewModel.userLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.player = it;
                binding.playerElo.text = "AkvELOn: " + it.statsOneOnOne.AkvELOn.toString()
                binding.BattlesCount.text = "B: " + it.statsOneOnOne.BattlesCount;
                binding.BattlesCount.text = "W: " + it.statsOneOnOne.WinsPresent + "%"
            }
        }
        ModuleContext.userViewModel.loadUserInfo(args.userId!!);


        binding.tabVs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    if (tab.position == 0) {
                        binding.TwoVsTwoCard.visibility = View.INVISIBLE;
                        binding.oneVsOneCard.visibility = View.VISIBLE;
                    } else {
                        binding.TwoVsTwoCard.visibility = View.VISIBLE;
                        binding.oneVsOneCard.visibility = View.INVISIBLE;
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}

        });


        binding.challengeToDuel.setOnClickListener {
            val duelInv = DuelInvitation();
            duelInv.senderId = CurrentUserId!!;
            duelInv.opponentId = args.userId!!;
            ModuleContext.vKikerServer.inviteToDuel(duelInv) {
                if (it?.Access == true) {
//                    val activity = requireActivity();
//                    val host =
//                        activity.supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment;
//                    BattleStates.BattleStates.postValue(BattleStates.WaitingOpponentState)
//                    host.findNavController().navigate(R.id.action_global_battleFragment);
                }
            }
        }
        return binding.root;
    }


}