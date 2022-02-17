package br.com.eliasjr.mercadolivro.controller

import br.com.eliasjr.mercadolivro.controller.request.PostBookRequest
import br.com.eliasjr.mercadolivro.extension.toBookModel
import br.com.eliasjr.mercadolivro.model.BookModel
import br.com.eliasjr.mercadolivro.service.BookService
import br.com.eliasjr.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("book")
class BookController (
    val bookService: BookService,
    val customerService: CustomerService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: PostBookRequest){
        val customer = customerService.getById(request.customerId)
        bookService.create(request.toBookModel(customer))
    }

    @GetMapping
    fun findAll(): List<BookModel> {
        return bookService.findAll()
    }

    @GetMapping("/active")
    fun findActives(): List<BookModel> =
        bookService.findActives()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int) : BookModel {
        return bookService.findById(id)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT )
    fun delete(@PathVariable id: Int){
        bookService.delete(id)
    }
}