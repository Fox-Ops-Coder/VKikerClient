package com.example.vkiker.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.vkiker.R
import com.example.vkiker.databinding.FragmentLoginBinding
import com.example.vkiker.databinding.LeaderboardFragmentBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null;
    private val binding get() = _binding!!;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);

        return binding.root;
    }


}