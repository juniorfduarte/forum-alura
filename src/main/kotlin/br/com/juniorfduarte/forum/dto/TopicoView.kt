package br.com.juniorfduarte.forum.dto

import br.com.juniorfduarte.forum.domain.StatusTopico
import br.com.juniorfduarte.forum.domain.Topico
import java.time.LocalDateTime

data class TopicoView(
    val id: Long?,
    val titulo: String,
    val mensagem: String,
    val status: StatusTopico,
    val dataCriacao: LocalDateTime
) {
    fun fromTopico(topico: Topico): TopicoView {
        return TopicoView(
            id = topico.id,
            titulo = topico.titulo,
            mensagem = topico.mensagem,
            status = topico.status,
            dataCriacao = topico.dataCriacao
        )
    }
}