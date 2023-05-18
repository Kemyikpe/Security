package com.starthub.securityApp.ui

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.starthub.securityApp.R
import com.starthub.securityApp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.bottomNavView
        val navController = findNavController(R.id.nav_host_fragment)


        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.guardFragment,
                R.id.notificationFragment,
                R.id.profileFragment
            )
        )

        //setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { controller, destination, _ ->

            when (destination.id) {
                R.id.homeFragment ,
                R.id.guardFragment,
                R.id.notificationFragment,
                R.id.profileFragment -> toggleBottomNav(View.VISIBLE, this)
                else -> toggleBottomNav(View.GONE, this)
            }
        }

    }

    private fun navigateToFragment(fragmentId: Int) {
        val navController = findNavController(R.id.nav_host_fragment)
        navController.navigate(fragmentId)
    }


    private fun toggleBottomNav(visibility: Int = View.VISIBLE, activity: Activity) {
        val bottomNavigationView = activity.findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        bottomNavigationView?.visibility = visibility
    }

}