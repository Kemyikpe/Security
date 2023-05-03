package com.starthub.securityApp.mainActivity

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.starthub.securityApp.R
import com.starthub.securityApp.databinding.FragmentLoginBinding
import java.util.regex.Pattern


class Login : Fragment() {

    private var binding: FragmentLoginBinding? = null

//    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_login, container, false)
        binding  = FragmentLoginBinding.inflate(inflater,container,false)

        val view = inflater.inflate(R.layout.fragment_login,container,false)
        val textView5 = view.findViewById<TextView>(R.id.textView5)
        val textView13 = view.findViewById<TextView>(R.id.textView13)

        textView5.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_forgotPassword2)
        }
        textView13.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }
    return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val email = view.findViewById<EditText>(R.id.editTextTextPersonName)
        val password = view.findViewById<EditText>(R.id.editText)
        val submit = view.findViewById<Button>(R.id.button2)

        submit.setOnClickListener {

            val email = email.text.toString().trim()
            val password = password.text.toString().trim()

            if (email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
            } else {
                Toast.makeText(requireContext(), "Enter valid Email address !", Toast.LENGTH_SHORT)
                    .show()
            }

            if (password.isNotEmpty() && isValidPassword(password)) {
                Toast.makeText(requireContext(), "Correct Password format !", Toast.LENGTH_SHORT)
                findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
//                val view = inflater.inflate(R.layout.fragment_login,container,false)
//                val button = view.findViewById<Button>(R.id.button)
//                button.setOnClickListener {
//                    findNavController().navigate(R.id.action_confirmationFragment_to_onboard_screenthreeFragment)
//                }

            } else {
                Toast.makeText(
                    requireContext(),
                    "Enter correct password format !",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }
    }

    fun isValidPassword(password: String): Boolean {
        password.let {
            val passwordPattern = Pattern.compile("^(?=.?[A-Z])(?=.?[a-z])(?=.*?\\d)")
            return passwordPattern.matcher(password).matches()
        }
    }



}



