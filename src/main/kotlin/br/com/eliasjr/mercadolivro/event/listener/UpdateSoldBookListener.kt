package br.com.eliasjr.mercadolivro.event.listener

import br.com.eliasjr.mercadolivro.event.PurchaseEvent
import br.com.eliasjr.mercadolivro.service.BookService
import br.com.eliasjr.mercadolivro.service.PurchaseService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.util.*

@Component
class UpdateSoldBookListener(
    private val bookService: BookService
) {

    @Async
    @EventListener
    fun listen(purchaseEvent: PurchaseEvent) {
        println("atualizando status dos livros")
        bookService.purchase(purchaseEvent.purchaseModel.books)
    }

}