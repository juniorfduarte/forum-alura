package br.com.juniorfduarte.forum.mapper

import br.com.juniorfduarte.forum.domain.Topico
import br.com.juniorfduarte.forum.dto.TopicoForm
import br.com.juniorfduarte.forum.service.CursoService
import br.com.juniorfduarte.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
): Mapper<TopicoForm, Topico> {


    override fun map(form: TopicoForm): Topico {
        val curso = cursoService.findById(form.idCurso)
        val usuario = usuarioService.findById(form.idAutor)

        return Topico(
            titulo = form.titulo,
            mensagem = form.mensagem,
            curso = curso,
            autor = usuario
        )
    }
}