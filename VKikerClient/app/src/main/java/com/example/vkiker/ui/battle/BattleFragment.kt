package com.example.vkiker.ui.battle

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
                BattleStates.NoBattleState -> {

                }
                BattleStates.WaitingOpponentState -> {
                    HideALl();
                    binding.textPleaseWaiting.visibility = View.VISIBLE;
                }
                BattleStates.WaitingBattleState -> {
                    HideALl();
                    binding.buttonStart.isEnabled = true;
                }
                BattleStates.OnBattleState->{

                }
            }


        }

        return binding.root;
    }

    fun HideALl() {
        binding.textPleaseWaiting.visibility = View.INVISIBLE;
        binding.buttonStart.isEnabled = false;
    }


}