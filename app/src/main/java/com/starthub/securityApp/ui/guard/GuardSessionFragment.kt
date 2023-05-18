package com.starthub.securityApp.ui.guard

import android.os.Bundle
import android.os.Message
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.starthub.securityApp.R
import com.starthub.securityApp.databinding.FragmentGuardSeesionBinding


open class GuardSessionFragment : BottomSheetDialogFragment() {
    private var binding: FragmentGuardSeesionBinding? = null
    lateinit var showDiaglogMessage: Message


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGuardSeesionBinding.inflate(inflater, container, false)

        val view = inflater.inflate(R.layout.fragment_guard_seesion, container, false)
        val button = view.findViewById<Button>(R.id.btn2)
        button.setOnClickListener {
            //var dialog = CustomDialogFragment()
            // dialog. show
            findNavController().navigate(R.id.action_dialogFragment_to_homeFragmentFragment)

        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.btn2)
        button.setOnClickListener {
            findNavController().navigate(R.id.action_dialogFragment_to_extendGaurdSessionTimeFragment)
        }

    }
}

