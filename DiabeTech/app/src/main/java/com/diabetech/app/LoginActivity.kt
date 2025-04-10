package com.diabetech.app

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.diabetech.app.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.signInButton.setOnClickListener {
            if (validateInputs()) {
                // TODO: Implement actual login logic
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }
        }

        binding.facebookButton.setOnClickListener {
            // TODO: Implement Facebook login
            Toast.makeText(this, "Facebook login clicked", Toast.LENGTH_SHORT).show()
        }

        binding.googleButton.setOnClickListener {
            // TODO: Implement Google login
            Toast.makeText(this, "Google login clicked", Toast.LENGTH_SHORT).show()
        }

        binding.twitterButton.setOnClickListener {
            // TODO: Implement Twitter login
            Toast.makeText(this, "Twitter login clicked", Toast.LENGTH_SHORT).show()
        }

        binding.forgotPasswordText.setOnClickListener {
            // TODO: Navigate to Reset Password screen
            Toast.makeText(this, "Reset Password clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validateInputs(): Boolean {
        var isValid = true

        with(binding) {
            // Email validation
            if (emailInput.text.isNullOrEmpty()) {
                emailInput.error = "Email is required"
                isValid = false
            }

            // Password validation
            if (passwordInput.text.isNullOrEmpty()) {
                passwordInput.error = "Password is required"
                isValid = false
            }
        }

        return isValid
    }
}
