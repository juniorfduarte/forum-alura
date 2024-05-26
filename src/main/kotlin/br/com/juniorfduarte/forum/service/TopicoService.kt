package br.com.juniorfduarte.forum.service

import br.com.juniorfduarte.forum.domain.Curso
import br.com.juniorfduarte.forum.domain.Topico
import br.com.juniorfduarte.forum.domain.Usuario
import br.com.juniorfduarte.forum.dto.TopicoForm
import br.com.juniorfduarte.forum.dto.TopicoView
import br.com.juniorfduarte.forum.mapper.TopicoFormMapper
import br.com.juniorfduarte.forum.mapper.TopicoViewMapper
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private var topicos: List<Topico>,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper
) {

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

        topicos = mutableListOf(topico1, topico2, topico3)
    }

    fun listar(): List<TopicoView> {
        return topicos.stream().map {
            it -> topicoViewMapper.map(it)
        }.collect(Collectors.toList())
    }

    fun findById(id: Long): TopicoView {
        val topico = topicos.stream().filter {
            it -> it.id == id
        }.findFirst().get()

        return topicoViewMapper.map(topico)
    }

    fun save(form: TopicoForm): List<TopicoView> {
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)
        return this.listar()
    }

}