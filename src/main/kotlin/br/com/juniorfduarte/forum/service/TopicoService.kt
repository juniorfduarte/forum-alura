package br.com.juniorfduarte.forum.service

import br.com.juniorfduarte.forum.domain.Curso
import br.com.juniorfduarte.forum.domain.Topico
import br.com.juniorfduarte.forum.domain.Usuario
import br.com.juniorfduarte.forum.dto.TopicoDto
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private var topicos: List<Topico>,
    private var cursoService: CursoService,
    private var usuarioService: UsuarioService
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

    fun listar(): List<Topico> {
        return topicos
    }

    fun findById(id: Long): Topico {
        return topicos.stream().filter {
            it -> it.id == id
        }.findFirst().get()
    }

    fun save(dto: TopicoDto): MutableList<List<Topico>> {
        val topicosList = mutableListOf(topicos)

        val curso = cursoService.findById(dto.idCurso)
        val usuario = usuarioService.findById(dto.idAutor)

        val topico = Topico(
                id = topicos.size.toLong().plus(1),
                titulo = dto.titulo,
                mensagem = dto.mensagem,
                curso = curso,
                autor = usuario
            )

        topicosList.plus(topico)
        return topicosList
    }

}