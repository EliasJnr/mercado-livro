package br.com.eliasjr.mercadolivro.service

import br.com.eliasjr.mercadolivro.enums.BookStatus
import br.com.eliasjr.mercadolivro.model.BookModel
import br.com.eliasjr.mercadolivro.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository
) {
    fun findById(id: Int): BookModel {
        return bookRepository.findById(id).orElseThrow()
    }

    fun create(book: BookModel) {
        bookRepository.save(book)
    }

    fun findAll(): List<BookModel> {
        return bookRepository.findAll().toList()
    }

    fun findActives(): List<BookModel> {
        return bookRepository.findByStatus(BookStatus.ATIVO)
    }

    fun delete(id: Int) {
        val book = findById(id)
        book.status = BookStatus.CANCELADO
        update(book)
    }

    fun update(book: BookModel) {
        bookRepository.save(book)
    }

}
