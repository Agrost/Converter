package com.example.converter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.example.converter.databinding.ActivityMainBinding
import android.R
import java.lang.Exception


class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStop() {
        _binding = null
        super.onStop()
    }

}