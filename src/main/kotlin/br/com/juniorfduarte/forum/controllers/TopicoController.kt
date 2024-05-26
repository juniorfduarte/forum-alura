package br.com.juniorfduarte.forum.controllers

import br.com.juniorfduarte.forum.domain.Topico
import br.com.juniorfduarte.forum.dto.TopicoForm
import br.com.juniorfduarte.forum.dto.TopicoView
import br.com.juniorfduarte.forum.service.TopicoService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topicos")
class TopicoController(
    private val service: TopicoService
) {

    @GetMapping
    fun listar(): List<TopicoView> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun getTopico(@PathVariable id: Long): TopicoView {
        return service.findById(id)
    }

    @PostMapping
    fun cadastroTopico(@RequestBody dto: TopicoForm): List<Topico> {
        return service.save(dto)
    }
}
