package br.com.juniorfduarte.forum.service

import br.com.juniorfduarte.forum.domain.Curso
import org.springframework.stereotype.Service

@Service
class CursoService(private var cursos: List<Curso>) {

    init {
        val curso1 = Curso(
            id = 1,
            nome = "Kotlin",
            categoria = "Programação"
        )

        val curso2 = Curso(
            id = 2,
            nome = "Kotlin Avançado",
            categoria = "Programação"
        )

        cursos = mutableListOf(curso1, curso2)
    }

    fun listar(): List<Curso> {
        return cursos
    }

    fun findById(id: Long): Curso {
        return cursos.stream().filter {
                it -> it.id == id
        }.findFirst().get()
    }

    // TODO -> Implementar função save

}