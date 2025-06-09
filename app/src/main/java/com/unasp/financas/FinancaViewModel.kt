package com.unasp.financas.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.unasp.financas.data.AppDatabase
import com.unasp.financas.model.Financa
import com.unasp.financas.repository.FinancaRepository
import kotlinx.coroutines.launch

class FinancaViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: FinancaRepository
    val todasFinancas: LiveData<List<Financa>>

    init {
        val dao = AppDatabase.getDatabase(application).financaDao()
        repository = FinancaRepository(dao)
        todasFinancas = repository.todasFinancas
    }

    fun inserir(financa: Financa) = viewModelScope.launch {
        repository.inserir(financa)
    }

    fun atualizar(financa: Financa) = viewModelScope.launch {
        repository.atualizar(financa)
    }

    fun deletar(financa: Financa) = viewModelScope.launch {
        repository.deletar(financa)
    }
}
