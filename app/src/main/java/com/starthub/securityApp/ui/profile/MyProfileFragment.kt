package com.starthub.securityApp.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.starthub.securityApp.R

/**
 * A simple [Fragment] subclass.
 * Use the [MyProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyProfileFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_profile, container, false)
    }



    }
