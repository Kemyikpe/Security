package com.starthub.securityApp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.starthub.securityApp.databinding.DiaglogBinding
import com.starthub.securityApp.databinding.FragmentDialogBinding
import com.starthub.securityApp.databinding.FragmentGetStartedBinding


open class DialogFragment : Fragment() {
    private var binding: FragmentDialogBinding? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDialogBinding.inflate(inflater,container,false)
        val view = inflater.inflate(R.layout.fragment_dialog,container,false)
         val button = view.findViewById<Button>(R.id.btn1)
        button .setOnClickListener {
            var dialog = CustomDialogFragment()
           // dialog. show

        }
return view




    }
}

