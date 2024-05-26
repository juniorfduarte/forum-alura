package br.com.juniorfduarte.forum.domain

import br.com.juniorfduarte.forum.dto.TopicoView
import java.time.LocalDateTime

data class Topico(
    val id: Long? = null,
    val titulo: String,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val curso: Curso,
    val autor: Usuario,
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,
    val respostas: List<Resposta> = ArrayList()
) {
    fun toTopicoView(): TopicoView {
        return TopicoView(
            id = this.id,
            titulo = this.titulo,
            mensagem = this.mensagem,
            status = this.status,
            dataCriacao = this.dataCriacao
        )
    }
}
