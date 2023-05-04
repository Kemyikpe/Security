package com.starthub.securityApp.mainActivity

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.starthub.securityApp.R
import com.starthub.securityApp.databinding.ActivityMain2Binding
import com.starthub.securityApp.databinding.FragmentDashboardBinding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    lateinit var result: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        result = findViewById(R.id.nav_view)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_view)
//        navController.navigate(R.id.homeFragment)


        val navView: BottomNavigationView = binding.navView
        val navHostFragment = supportFragmentManager



        navController.navigate(R.id.nav_view)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.navigation_dashboard,
                R.id.guardFragment,
                R.id.profileFragment
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }


}