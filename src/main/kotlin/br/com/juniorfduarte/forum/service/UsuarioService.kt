package br.com.juniorfduarte.forum.service

import br.com.juniorfduarte.forum.domain.Usuario
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    private var usuarios: List<Usuario>
) {

    init {
        val usuario1 = Usuario(
            id =1,
            nome = "Ana da Silva",
            email = "ana@email.com"
        )

        val usuario2 = Usuario(
            id =2,
            nome = "João da Silva",
            email = "joao@email.com"
        )

        usuarios = mutableListOf(usuario1, usuario2)
    }


    fun listar(): List<Usuario> {
        return usuarios
    }

    fun findById(id: Long): Usuario {
        return usuarios.stream().filter {
                it -> it.id == id
        }.findFirst().get()
    }

    // TODO -> Implementar função save

}