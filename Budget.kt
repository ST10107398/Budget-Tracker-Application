class BudgetViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: BudgetRepository
    val allEntries: LiveData<List<BudgetEntry>>

    init {
        val dao = BudgetDatabase.getDatabase(application).budgetDao()
        repository = BudgetRepository(dao)
        allEntries = repository.allEntries
    }

    fun insert(entry: BudgetEntry) = viewModelScope.launch {
        repository.insert(entry)
    }

    fun update(entry: BudgetEntry) = viewModelScope.launch {
        repository.update(entry)
    }

    fun delete(entry: BudgetEntry) = viewModelScope.launch {
        repository.delete(entry)
    }
}
