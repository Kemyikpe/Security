package com.starthub.securityApp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.starthub.securityApp.databinding.FragmentWelcomeBinding

class Emergency: Fragment(){
    private var _binding: FragmentWelcomeBinding? = null

    // with th
    // e backing property of the kotlin we extract
// the non null value of the _binding
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)

        binding.button2.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_signUpFragment)

        }
        binding.button3.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_loginFragment)

        }



            return binding.root
    }
}







