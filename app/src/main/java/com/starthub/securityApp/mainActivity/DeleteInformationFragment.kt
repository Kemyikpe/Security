package com.starthub.securityApp.mainActivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.starthub.securityApp.R
import com.starthub.securityApp.databinding.FragmentDeleteInformationBinding


class DeleteInformationFragment : BottomSheetDialogFragment() {
    private lateinit var binding : FragmentDeleteInformationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDeleteInformationBinding.inflate(layoutInflater)

        return binding .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.button3.setOnClickListener {
            findNavController().navigate(R.id.action_deleteInformationFragment_to_confirmDeleteFragment)
        }
        binding.button4.setOnClickListener {
            findNavController().navigate(R.id.action_deleteInformationFragment_to_informationSavedFragment)
        }
    }

    }



