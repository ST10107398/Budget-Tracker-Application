package com.example.authentication.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BudgetDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEntry(entry: BudgetEntry)

    @Update
    suspend fun updateEntry(entry: BudgetEntry)

    @Delete
    suspend fun deleteEntry(entry: BudgetEntry)

    @Query("SELECT * FROM budget_entries ORDER BY date DESC")
    fun getAllEntries(): LiveData<List<BudgetEntry>>
}
