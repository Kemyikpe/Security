package com.starthub.securityApp.utils

import android.app.Activity
import android.content.Context
import com.starthub.securityApp.R

object Animation{

    fun animateSlideLeft(context: Context) {
        (context as Activity).overridePendingTransition(
            R.anim.animate_slide_left_enter,
            R.anim.animate_slide_left_exit
        )
    }

}