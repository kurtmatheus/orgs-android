package br.com.alura.orgs.ui.activity

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import br.com.alura.orgs.databinding.ActivityPerfilUsuarioBinding
import br.com.alura.orgs.model.Usuario
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

class PerfilUsuarioActivity : UsuarioBaseActivity() {

    private val binding by lazy {
        ActivityPerfilUsuarioBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configuraBotaoDeslogar()
        preencheCampos()
    }

    private fun preencheCampos() {
        lifecycleScope.launch {
            usuario.filterNotNull().collect { usuario ->
                with(binding) {
                    activityPerfilUsuarioId.text = usuario.id
                    activityPerfilUsuarioNome.text = usuario.nome
                }
            }
        }
    }

    private fun configuraBotaoDeslogar() {
        binding.activityPerfilUsuarioDeslogar.setOnClickListener {
            lifecycleScope.launch {
                deslogaUsuario()
            }
        }
    }

}