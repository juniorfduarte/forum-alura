package br.com.juniorfduarte.forum.service

import br.com.juniorfduarte.forum.domain.Curso
import br.com.juniorfduarte.forum.domain.Resposta
import br.com.juniorfduarte.forum.domain.Topico
import br.com.juniorfduarte.forum.domain.Usuario
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class RespostaService(private var respostas: List<Resposta>) {

    init {
        val curso = Curso(
            id = 1,
            nome = "Kotlin",
            categoria = "Programacao"
        )
        val autor = Usuario(
            id = 1,
            nome = "Ana da Silva",
            email = "ana@email.com"
        )
        val topico = Topico(
            id = 1,
            titulo = "Duvida Kotlin",
            mensagem = "Variaveis no Kotlin",
            curso = curso,
            autor = autor
        )

        val resposta = Resposta(
            id = 1,
            mensagem = "Resposta 1",
            autor = autor,
            topico = topico,
            solucao = false
        )

        val resposta2 = Resposta(
            id = 2,
            mensagem = "Resposta 2",
            autor = autor,
            topico = topico,
            solucao = false
        )

        respostas = mutableListOf(resposta, resposta2)
    }

    fun getRespostasByTopicoId(id: Long): List<Resposta> {
        return respostas.stream().filter { r ->
            r.topico.id == id
        }.collect(Collectors.toList())
    }

    // TODO -> Implementar função save
}