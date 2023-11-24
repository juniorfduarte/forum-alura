package br.com.juniorfduarte.forum.service

import br.com.juniorfduarte.forum.domain.Curso
import br.com.juniorfduarte.forum.domain.Topico
import br.com.juniorfduarte.forum.domain.Usuario
import org.springframework.stereotype.Service

@Service
class TopicoService(private var topicos: List<Topico>) {

    init {
        val topico1 = Topico(
            id = 1,
            titulo = "Dúvida",
            mensagem = "Variáveis kotlin 1",
            curso = Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Programação"
            ),
            autor = Usuario(
                id =1,
                nome = "Ana da Silva",
                email = "ana@email.com"
            )
        )

        val topico2 = Topico(
            id = 2,
            titulo = "Dúvida",
            mensagem = "Variáveis kotlin 2",
            curso = Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Programação"
            ),
            autor = Usuario(
                id =1,
                nome = "Ana da Silva",
                email = "ana@email.com"
            )
        )

        val topico3 = Topico(
            id = 3,
            titulo = "Dúvida kotlin 3",
            mensagem = "Variáveis kotlin",
            curso = Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Programação"
            ),
            autor = Usuario(
                id =1,
                nome = "Ana da Silva",
                email = "ana@email.com"
            )
        )

        topicos = listOf(topico1, topico2, topico3)
    }

    fun listar(): List<Topico> {
        return topicos
    }

    fun findById(id: Long): Topico {
        return topicos.stream().filter {
            t -> t.id == id
        }.findFirst().get()
    }

    fun save(topico: Topico): List<Topico> {

        val list = listOf<Topico>()

        topicos.plus(topico)
        return topicos
    }

}