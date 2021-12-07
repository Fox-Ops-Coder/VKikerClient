package com.example.vkiker.ui.battle

import android.content.Context
import android.content.res.ColorStateList
import android.os.Bundle
import android.os.SystemClock
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.vkiker.R
import com.example.vkiker.connection.BattleStates
import com.example.vkiker.databinding.FragmentBattleBinding
import com.example.vkiker.databinding.LeaderboardFragmentBinding
import com.foxdev.vkikermodule.context.ModuleContext
import com.foxdev.vkikermodule.current.CurrentUser
import com.foxdev.vkikermodule.net.netobjects.BattleResults
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

        val battleRes = BattleResults();
        //
        BattleStates.BattleStates.observe(viewLifecycleOwner) {
            val storageName = getString(R.string.loginStorageName)
            val mySharedPreferences =
                requireActivity().getSharedPreferences(storageName, Context.MODE_PRIVATE);
            val user = CurrentUser(mySharedPreferences);
            val userId = user.currentUser;
            battleRes.id = userId!!;
            when (it) {
                BattleStates.WaitingBattleState -> {
                    HideALl();
                    binding.buttonStart.isEnabled = true;
                    binding.buttonStart.setOnClickListener {
                        ModuleContext.vKikerServer.readyForBattle(userId!!) {
                        }
                    }
                }
                BattleStates.OnBattleState -> {
                    HideALl();
                    binding.chronometer.base = SystemClock.elapsedRealtime();
                    binding.chronometer.start();
                    binding.buttonStart.isEnabled = true;
                    binding.buttonStart.text = "Stop"
                    //
                    val color = ContextCompat.getColor(requireContext(), R.color.red);
                    //and then... this is the end
                    //
                    binding.buttonStart.setOnClickListener {
                        binding.chronometer.stop();
                        ModuleContext.vKikerServer.stopBattle(userId!!) { }
                        BattleStates.BattleStates.postValue(BattleStates.OnBattleEndedState)
                    }
                }
                BattleStates.OnBattleEndedState -> {
                    HideALl();
                    binding.ILose.visibility = View.VISIBLE
                    binding.IWin.visibility = View.VISIBLE
                    binding.ILose.setOnClickListener {
                        battleRes.winner = false;
                        binding.seekBar.visibility = View.VISIBLE
                        binding.seekbarText.visibility = View.VISIBLE
                        binding.buttonConfirm.visibility = View.VISIBLE;

                    }
                    binding.IWin.setOnClickListener {
                        battleRes.winner = true;
                        binding.seekBar.visibility = View.VISIBLE
                        binding.seekbarText.visibility = View.VISIBLE
                        binding.buttonConfirm.visibility = View.VISIBLE;
                    }

                    binding.seekBar.setOnSeekBarChangeListener(object :
                        SeekBar.OnSeekBarChangeListener {
                        override fun onProgressChanged(
                            seekBar: SeekBar?,
                            progress: Int,
                            fromUser: Boolean
                        ) {
                        }

                        override fun onStartTrackingTouch(seekBar: SeekBar?) {
                        }

                        override fun onStopTrackingTouch(seekBar: SeekBar?) {
                            binding.seekbarText.text = seekBar?.progress.toString();
                            battleRes.goals = seekBar?.progress!!;
                        }

                    });
                    binding.buttonConfirm.setOnClickListener {
                        ModuleContext.vKikerServer.sendResults(battleRes)
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
        binding.buttonConfirm.visibility = View.INVISIBLE;
        binding.buttonStart.isEnabled = false;

    }


}