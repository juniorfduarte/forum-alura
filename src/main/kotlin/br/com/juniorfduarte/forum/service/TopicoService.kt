package br.com.juniorfduarte.forum.service

import br.com.juniorfduarte.forum.domain.Curso
import br.com.juniorfduarte.forum.domain.Topico
import br.com.juniorfduarte.forum.domain.Usuario
import br.com.juniorfduarte.forum.dto.TopicoForm
import br.com.juniorfduarte.forum.dto.TopicoView
import org.springframework.stereotype.Service
import java.util.stream.Collectors

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

    fun listar(): List<TopicoView> {
        return topicos.stream().map {
            it -> it.toTopicoView()
        }.collect(Collectors.toList())
    }

    fun findById(id: Long): TopicoView {
        return topicos.stream().filter {
            it -> it.id == id
        }.findFirst().get().toTopicoView()
    }

    fun save(dto: TopicoForm): List<Topico> {
        val curso = cursoService.findById(dto.idCurso)
        val usuario = usuarioService.findById(dto.idAutor)

        val topico = Topico(
                id = topicos.size.toLong().plus(1),
                titulo = dto.titulo,
                mensagem = dto.mensagem,
                curso = curso,
                autor = usuario
            )

        topicos = topicos.plus(topico)
        return topicos
    }

}