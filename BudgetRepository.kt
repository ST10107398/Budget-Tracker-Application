class BudgetRepository(private val dao: BudgetDao) {
    val allEntries: LiveData<List<BudgetEntry>> = dao.getAllEntries()

    suspend fun insert(entry: BudgetEntry) = dao.insertEntry(entry)
    suspend fun update(entry: BudgetEntry) = dao.updateEntry(entry)
    suspend fun delete(entry: BudgetEntry) = dao.deleteEntry(entry)
}
