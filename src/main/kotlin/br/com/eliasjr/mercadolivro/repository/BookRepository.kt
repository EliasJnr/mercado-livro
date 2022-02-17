package br.com.eliasjr.mercadolivro.repository

import br.com.eliasjr.mercadolivro.enums.BookStatus
import br.com.eliasjr.mercadolivro.model.BookModel
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookModel, Int> {
    fun findByStatus(status: BookStatus): List<BookModel>

}