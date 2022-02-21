package br.com.eliasjr.mercadolivro.event.listener

import br.com.eliasjr.mercadolivro.event.PurchaseEvent
import br.com.eliasjr.mercadolivro.service.BookService
import br.com.eliasjr.mercadolivro.service.PurchaseService
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import java.util.*

@Component
class UpdateSoldBookListener(
    private val bookService: BookService
) {

    @EventListener
    fun listen(purchaseEvent: PurchaseEvent) {
        bookService.purchase(purchaseEvent.purchaseModel.books)
    }

}