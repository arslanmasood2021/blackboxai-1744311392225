package com.diabetech.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.diabetech.app.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.scanButton.setOnClickListener {
            // TODO: Implement retinopathy scan functionality
        }

        // TODO: Set up RecyclerView for doctors
        // binding.doctorsRecyclerView.adapter = ...
    }
}
