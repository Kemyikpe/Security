package com.starthub.securityApp

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import java.util.regex.Pattern


class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val email = view.findViewById<EditText>(R.id.editTextTextPersonName)
        val password = view.findViewById<EditText>(R.id.editText)
        val submit = view.findViewById<Button>(R.id.button2)
        val text = view.findViewById<TextView>(R.id.textView5)
        val text2 = view.findViewById<TextView>(R.id.textView13)


        submit.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)

//            val email = email.text.toString().trim()
//            val password = password.text.toString().trim()
//
//            if (email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//                Toast.makeText(requireContext(), "Email Verified !", Toast.LENGTH_SHORT).show()
//            } else {
//                Toast.makeText(requireContext(), "Enter valid Email address !", Toast.LENGTH_SHORT)
//                    .show()
//            }
//
//            if (password.isNotEmpty() && isValidPassword(password)) {
//                Toast.makeText(requireContext(), "Correct Password format !", Toast.LENGTH_SHORT).show()
//            } else {
//                Toast.makeText(requireContext(), "Enter correct password format !", Toast.LENGTH_SHORT)
//                    .show()
//            }
        }

        text.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_forgotPassword2)

        }

        text2.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)


            fun isValidPassword(password: String): Boolean {
                password.let {
                    val passwordPattern = Pattern.compile("^(?=.?[A-Z])(?=.?[a-z])(?=.*?\\d)")
                    return passwordPattern.matcher(password).matches()
                }
            }
        }
    }
}




