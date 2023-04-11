package com.starthub.securityApp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.starthub.securityApp.databinding.FragmentGuardSeesionBinding


open class GuardSessionFragment : Fragment() {
    private var binding: FragmentGuardSeesionBinding? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGuardSeesionBinding.inflate(inflater,container,false)
        val view = inflater.inflate(R.layout.fragment_guard_seesion,container,false)
         val button = view.findViewById<Button>(R.id.btn1)
        button .setOnClickListener {
            var dialog = CustomDialogFragment()
           // dialog. show

        }
return view




    }
}

