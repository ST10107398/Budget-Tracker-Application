package com.example.authentication.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "budget_entries")
data class BudgetEntry(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val amount: Double,
    val category: String,
    val date: String
)
