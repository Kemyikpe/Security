package com.starthub.securityApp.mainActivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.starthub.securityApp.R
import com.starthub.securityApp.databinding.FragmentLoginBinding
import com.starthub.securityApp.databinding.FragmentSignUpBinding


class SignUp : Fragment() {
    private var binding: FragmentSignUpBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding  = FragmentSignUpBinding.inflate(inflater,container,false)
        val view = inflater.inflate(R.layout.fragment_sign_up,container,false)
        val button = view.findViewById<Button>(R.id.button2)

        button.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_emailVerificationFragment)
        }
        return view

    }


}