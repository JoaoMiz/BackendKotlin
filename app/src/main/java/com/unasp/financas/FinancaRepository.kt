package com.unasp.financas.repository

import androidx.lifecycle.LiveData
import com.unasp.financas.data.FinancaDao
import com.unasp.financas.model.Financa

class FinancaRepository(private val dao: FinancaDao) {

    val todasFinancas: LiveData<List<Financa>> = dao.getTodas()

    suspend fun inserir(financa: Financa) {
        dao.inserir(financa)
    }

    suspend fun atualizar(financa: Financa) {
        dao.atualizar(financa)
    }

    suspend fun deletar(financa: Financa) {
        dao.deletar(financa)
    }
}
