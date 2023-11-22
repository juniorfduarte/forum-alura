package br.com.juniorfduarte.forum.controllers

import br.com.juniorfduarte.forum.domain.Curso
import br.com.juniorfduarte.forum.domain.Topico
import br.com.juniorfduarte.forum.domain.Usuario
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topicos")
class TopicoController {

    @GetMapping
    fun listar(): List<Topico> {
        val topico = Topico(
            id = 1,
            titulo = "dúvida",
            mensagem = "Variáveis kotlin",
            curso = curso,
            autor = usuario
        )

        return listOf(topico)
    }

    val curso = Curso(
        id = 1,
        nome = "Kotlin",
        categoria = "Programação"
    )

    val usuario = Usuario(
        id =1,
        nome = "Ana da Silva",
        email = "ana@email.com"
    )
}
