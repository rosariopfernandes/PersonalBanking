package io.github.rosariopfernandes.personalbanking.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import io.github.rosariopfernandes.personalbanking.model.Category
import io.github.rosariopfernandes.personalbanking.model.Source
import io.github.rosariopfernandes.personalbanking.util.BankingDatabase

class SourcesViewModel(val app:Application) : AndroidViewModel(app) {

    var sources: LiveData<List<Source>>? = null
    var database: BankingDatabase? = null

    init {
        database = BankingDatabase.getInstance(app.applicationContext)
        sources = database!!.sourceDao().selectAll()
    }

}