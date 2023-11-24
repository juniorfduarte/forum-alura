package br.com.juniorfduarte.forum.controllers

import br.com.juniorfduarte.forum.domain.Resposta
import br.com.juniorfduarte.forum.service.RespostaService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("topicos/{id}/respostas")
class RespostaController(
    private val service: RespostaService
) {

    @GetMapping
    fun getRespostas(@PathVariable id: Long): List<Resposta> {
        return service.getRespostasByTopicoId(id)
    }
}