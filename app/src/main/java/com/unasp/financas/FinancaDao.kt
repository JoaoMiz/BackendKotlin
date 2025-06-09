package com.unasp.financas.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.unasp.financas.model.Financa

@Dao
interface FinancaDao {
    @Query("SELECT * FROM financas ORDER BY id DESC")
    fun getTodas(): LiveData<List<Financa>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserir(financa: Financa)

    @Update
    suspend fun atualizar(financa: Financa)

    @Delete
    suspend fun deletar(financa: Financa)
}