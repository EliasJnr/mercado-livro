package br.com.eliasjr.mercadolivro.controller.mapper

import br.com.eliasjr.mercadolivro.controller.request.PostPurchaseRequest
import br.com.eliasjr.mercadolivro.model.PurchaseModel
import br.com.eliasjr.mercadolivro.service.BookService
import br.com.eliasjr.mercadolivro.service.CustomerService
import org.springframework.stereotype.Component

@Component
class PurchaseMapper(
    private val bookService: BookService,
    private val customerService: CustomerService
) {

    fun toModel(request: PostPurchaseRequest): PurchaseModel {
        val customer = customerService.findById(request.costumerId)
        val books = bookService.findAllByIds(request.bookIds)

        return PurchaseModel(
            customer = customer,
            books = books,
            price = books.sumOf { it.price }
        )
    }
}