package com.example.authentication

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.authentication.databinding.AddExpensesBinding


class addexpenses : AppCompatActivity() {

    private lateinit var binding: AddExpensesBinding
    private val categories = listOf("Food", "Transport", "School", "Entertainment", "Utilities", "Health", "Travel", "Clothing")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AddExpensesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Populate the category dropdown with the custom layout
        val adapter = ArrayAdapter(this, R.layout.dropdown_item, android.R.id.text1, categories)
        binding.categoryDropdown.setAdapter(adapter)

        // Save button click listener
        binding.saveExpenseButton.setOnClickListener {
            val selectedCategory = binding.categoryDropdown.text.toString().trim()
            val amountText = binding.amountInput.text.toString().trim()
            val description = binding.descriptionInput.text.toString().trim()

            // Validate inputs
            if (selectedCategory.isEmpty() || !categories.contains(selectedCategory)) {
                Toast.makeText(this, "Please select a valid category", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (amountText.isEmpty()) {
                Toast.makeText(this, "Please enter an amount", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val amount = amountText.toDoubleOrNull()
            if (amount == null || amount <= 0) {
                Toast.makeText(this, "Please enter a valid amount greater than 0", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Format the amount to 2 decimal places for the Toast message
            val formattedAmount = String.format("%.2f", amount)
            Toast.makeText(this, "Expense of $$formattedAmount added to $selectedCategory", Toast.LENGTH_SHORT).show()
            finish()
        }

        // Cancel button click listener
        binding.cancelButton.setOnClickListener {
            finish()
        }
    }
}