package com.unasp.financas.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "financas")
data class Financa(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val valor: Double,
    val data: String, // formato: "dd/MM/yyyy"
    val recorrente: Boolean
)