package com.utad.practica_ud2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.utad.practica_ud2.databinding.ActivityHomeBinding


@Suppress("DEPRECATION")
class HomeActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityHomeBinding
    private val binding :ActivityHomeBinding get() = _binding

    private lateinit var navController:NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(binding.nhfHomeActivity.id)
        navController = navHostFragment?.findNavController()!!

        val categoria = intent.getStringExtra("categoria")
        val nombre = intent.getStringExtra("nombre")


        when(categoria){
            "Generales"->{
                navController.navigate(R.id.generalNewsFragment)
            }
            "Deportes"-> {
                navController.navigate(R.id.sportNewsFragment)
            }
            "Tecnologia"->{
                navController.navigate(R.id.techNewsFragment)
            }
        }

        binding.bnbHomeActivity.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.generalNewsFragment -> {
                    navController.navigate(R.id.generalNewsFragment)
                    true
                }
                R.id.sportNewsFragment -> {
                    navController.navigate(R.id.sportNewsFragment)
                    true
                }
                R.id.techNewsFragment -> {
                    navController.navigate(R.id.techNewsFragment)
                    true
                }
                else -> false
            }
        }



    }


}