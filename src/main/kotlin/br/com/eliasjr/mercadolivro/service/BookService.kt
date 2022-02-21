package br.com.eliasjr.mercadolivro.service

import br.com.eliasjr.mercadolivro.enums.BookStatus
import br.com.eliasjr.mercadolivro.enums.Errors
import br.com.eliasjr.mercadolivro.exception.NotFoundException
import br.com.eliasjr.mercadolivro.model.BookModel
import br.com.eliasjr.mercadolivro.model.CustomerModel
import br.com.eliasjr.mercadolivro.repository.BookRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository
) {
    fun findById(id: Int): BookModel {
        return bookRepository.findById(id)
            .orElseThrow { NotFoundException(Errors.ML101.message.format(id), Errors.ML101.code) }
    }

    fun create(book: BookModel) {
        bookRepository.save(book)
    }

    fun findAll(pageable: Pageable): Page<BookModel> {
        return bookRepository.findAll(pageable)
    }

    fun findActives(pageable: Pageable): Page<BookModel> {
        return bookRepository.findByStatus(BookStatus.ATIVO, pageable)
    }

    fun delete(id: Int) {
        val book = findById(id)
        book.status = BookStatus.CANCELADO
        update(book)
    }

    fun update(book: BookModel) {
        bookRepository.save(book)
    }

    fun deleteByCustomer(customer: CustomerModel) {
        val books = bookRepository.findByCustomer(customer)
        for (book in books) {
            book.status = BookStatus.DELETADO
        }
        bookRepository.saveAll(books)
    }

    fun findAllByIds(bookIds: Set<Int>): List<BookModel> {
        return bookRepository.findAllById(bookIds).toList()
    }

    fun purchase(books: MutableList<BookModel>) {
        books.map {
            it.status = BookStatus.VENDIDO
        }
        bookRepository.saveAll(books)
    }

}
