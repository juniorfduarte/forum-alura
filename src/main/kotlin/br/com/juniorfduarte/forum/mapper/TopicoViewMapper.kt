package br.com.juniorfduarte.forum.mapper

import br.com.juniorfduarte.forum.domain.Topico
import br.com.juniorfduarte.forum.dto.TopicoView
import org.springframework.stereotype.Component

@Component
class TopicoViewMapper: Mapper<Topico, TopicoView> {

    override fun map(t: Topico): TopicoView {
        return TopicoView(
            t.id,
            t.titulo,
            t.mensagem,
            t.status,
            t.dataCriacao
        )
    }
}