package br.com.juniorfduarte.forum.dto

data class TopicoDto (
    val titulo: String,
    val mensagem: String,
    val idCurso: Long,
    val idAutor: Long
)