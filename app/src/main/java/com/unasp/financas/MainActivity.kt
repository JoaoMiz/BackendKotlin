package com.unasp.financas

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.unasp.financas.model.Financa
import com.unasp.financas.viewmodel.FinancaViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: FinancaViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewModel = ViewModelProvider(this)[FinancaViewModel::class.java]

        val novaFinanca = Financa(
            nome = "Academia",
            valor = 59.90,
            data = "09/06/2025",
            recorrente = true
        )

        viewModel.inserir(novaFinanca)
    }
}