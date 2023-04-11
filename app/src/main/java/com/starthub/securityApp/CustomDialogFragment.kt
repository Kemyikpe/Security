package com.starthub.securityApp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class CustomDialogFragment :GuardSessionFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView:View =inflater.inflate(R.layout.fragment_guard_seesion,container,false)
        return rootView
    }
}