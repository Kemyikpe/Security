package com.starthub.securityApp.mainActivity

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.navigation.findNavController
import com.starthub.securityApp.R
import com.starthub.securityApp.databinding.ActivityMainBinding
import com.starthub.securityApp.databinding.FragmentSignUpBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        val navHostFragment = supportFragmentManager

        val intent = Intent(this@MainActivity,MainActivity2:: class.java)
        startActivity(intent)


//        navHostFragment.setupWithNavController(navController)




    }


}
