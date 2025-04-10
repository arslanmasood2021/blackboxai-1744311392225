package com.diabetech.app

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.diabetech.app.databinding.ActivityProfileCompletionBinding
import java.util.*

class ProfileCompletionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileCompletionBinding
    private val calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileCompletionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupCityDropdown()
        setupDatePickers()
        setupSliders()
        setupClickListeners()
    }

    private fun setupCityDropdown() {
        val cities = arrayOf("New York", "Los Angeles", "Chicago", "Houston", "Phoenix")
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, cities)
        binding.cityInput.setAdapter(adapter)
    }

    private fun setupDatePickers() {
        binding.dateInput.setOnClickListener {
            showDatePicker()
        }
        binding.monthInput.setOnClickListener {
            showMonthPicker()
        }
        binding.yearInput.setOnClickListener {
            showYearPicker()
        }
    }

    private fun setupSliders() {
        binding.weightSlider.addOnChangeListener { _, value, _ ->
            // Update weight value display
            binding.weightSlider.contentDescription = "${value.toInt()} kg"
        }

        binding.heightSlider.addOnChangeListener { _, value, _ ->
            // Update height value display
            binding.heightSlider.contentDescription = "${value.toInt()} cm"
        }
    }

    private fun setupClickListeners() {
        binding.continueButton.setOnClickListener {
            if (validateInputs()) {
                saveProfileData()
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }
        }
    }

    private fun showDatePicker() {
        DatePickerDialog(
            this,
            { _, year, month, day ->
                binding.dateInput.setText(day.toString())
                binding.monthInput.setText((month + 1).toString())
                binding.yearInput.setText(year.toString())
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    private fun showMonthPicker() {
        // For simplicity, we'll use the same date picker
        showDatePicker()
    }

    private fun showYearPicker() {
        // For simplicity, we'll use the same date picker
        showDatePicker()
    }

    private fun validateInputs(): Boolean {
        var isValid = true

        with(binding) {
            if (cityInput.text.isNullOrEmpty()) {
                cityInput.error = "Please select your city"
                isValid = false
            }

            if (dateInput.text.isNullOrEmpty() || 
                monthInput.text.isNullOrEmpty() || 
                yearInput.text.isNullOrEmpty()) {
                Toast.makeText(this@ProfileCompletionActivity, 
                    "Please select your date of birth", 
                    Toast.LENGTH_SHORT).show()
                isValid = false
            }

            if (genderRadioGroup.checkedRadioButtonId == -1) {
                Toast.makeText(this@ProfileCompletionActivity, 
                    "Please select your gender", 
                    Toast.LENGTH_SHORT).show()
                isValid = false
            }
        }

        return isValid
    }

    private fun saveProfileData() {
        // TODO: Implement profile data saving logic
        val weight = binding.weightSlider.value
        val height = binding.heightSlider.value
        val gender = when (binding.genderRadioGroup.checkedRadioButtonId) {
            R.id.maleRadio -> "Male"
            R.id.femaleRadio -> "Female"
            R.id.otherRadio -> "Other"
            else -> ""
        }

        // Here you would typically save this data to your backend or local storage
        Toast.makeText(this, "Profile completed successfully!", Toast.LENGTH_SHORT).show()
    }
}
