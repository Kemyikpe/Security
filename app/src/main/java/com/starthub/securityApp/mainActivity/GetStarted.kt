package com.starthub.securityApp.mainActivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.starthub.securityApp.R
import com.starthub.securityApp.databinding.FragmentGetStartedBinding

class GetStarted : Fragment() {

    private var _binding: FragmentGetStartedBinding? = null

    // with the backing property of the kotlin we extract
    // the non null value of the _binding
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentGetStartedBinding.inflate(inflater, container, false)

        binding.button.setOnClickListener {

            findNavController().navigate(R.id.action_getStarted_to_onBoardingFragment)


        }

        return binding.root
    }

}
