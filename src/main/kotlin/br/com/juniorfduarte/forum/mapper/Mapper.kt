package br.com.juniorfduarte.forum.mapper

interface Mapper<T, U> {

    fun map(t: T): U
}
