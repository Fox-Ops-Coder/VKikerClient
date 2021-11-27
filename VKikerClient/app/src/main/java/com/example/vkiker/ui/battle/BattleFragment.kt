package com.example.vkiker.ui.battle

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.vkiker.R
import com.example.vkiker.connection.BattleStates
import com.example.vkiker.databinding.FragmentBattleBinding
import com.example.vkiker.databinding.LeaderboardFragmentBinding
import com.foxdev.vkikermodule.context.ModuleContext
import com.foxdev.vkikermodule.current.CurrentUser
import kotlin.concurrent.timer


class BattleFragment : Fragment() {

    private var _binding: FragmentBattleBinding? = null;
    private val binding get() = _binding!!;
    private var isTimerStopped: Boolean = false;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_battle, container, false);
        binding.lifecycleOwner = viewLifecycleOwner;

        //
        BattleStates.BattleStates.observe(viewLifecycleOwner) {
            when (it) {
                BattleStates.WaitingBattleState -> {
                    HideALl();
                    binding.buttonStart.isEnabled = true;
                    binding.buttonStart.setOnClickListener {
                        val storageName = getString(R.string.loginStorageName)
                        val mySharedPreferences = requireActivity().getSharedPreferences(
                            storageName,
                            Context.MODE_PRIVATE
                        );
                        val user = CurrentUser(mySharedPreferences);
                        val userId = user.currentUser;
                        ModuleContext.vKikerServer.readyForBattle(userId!!) {

                        }
                    }
                }
                BattleStates.OnBattleState -> {
                    binding.chronometer.start();
                    binding.buttonStart.isEnabled = true;
                    binding.buttonStart.text = "Stop"
                    binding.buttonStart.setOnClickListener {


                    }


                }
            }


        }

        return binding.root;
    }

    fun HideALl() {
        binding.ILose.visibility = View.INVISIBLE
        binding.IWin.visibility = View.INVISIBLE
        binding.seekBar.visibility = View.INVISIBLE
        binding.seekbarText.visibility = View.INVISIBLE
        binding.buttonStart.isEnabled = false;

    }


}