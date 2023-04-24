package br.com.alura.orgs.ui.activity

import br.com.alura.orgs.database.AppDatabase
import br.com.alura.orgs.databinding.ActivityTodosProdutosBinding

class TodosProdutosActivity : UsuarioBaseActivity() {

    private val binding by lazy {
        ActivityTodosProdutosBinding.inflate(layoutInflater)
    }

    private val dao by lazy {
        AppDatabase.getInstancia(this).produtoDao()
    }


}