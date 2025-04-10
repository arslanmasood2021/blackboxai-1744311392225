package com.diabetech.app

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.diabetech.app.databinding.ActivitySignupBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.continueButton.setOnClickListener {
            if (validateInputs()) {
                // TODO: Implement actual signup logic
                startActivity(Intent(this, ProfileCompletionActivity::class.java))
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
    }

    private fun validateInputs(): Boolean {
        var isValid = true

        with(binding) {
            // Phone number validation
            if (phoneNumberInput.text.isNullOrEmpty()) {
                phoneNumberInput.error = "Phone number is required"
                isValid = false
            }

            // Email validation
            if (emailInput.text.isNullOrEmpty()) {
                emailInput.error = "Email is required"
                isValid = false
            } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailInput.text).matches()) {
                emailInput.error = "Invalid email format"
                isValid = false
            }

            // Full name validation
            if (fullNameInput.text.isNullOrEmpty()) {
                fullNameInput.error = "Full name is required"
                isValid = false
            }

            // Password validation
            if (passwordInput.text.isNullOrEmpty()) {
                passwordInput.error = "Password is required"
                isValid = false
            } else if (passwordInput.text.length < 6) {
                passwordInput.error = "Password must be at least 6 characters"
                isValid = false
            }

            // Confirm password validation
            if (confirmPasswordInput.text.isNullOrEmpty()) {
                confirmPasswordInput.error = "Please confirm your password"
                isValid = false
            } else if (confirmPasswordInput.text.toString() != passwordInput.text.toString()) {
                confirmPasswordInput.error = "Passwords do not match"
                isValid = false
            }
        }

        return isValid
    }
}
