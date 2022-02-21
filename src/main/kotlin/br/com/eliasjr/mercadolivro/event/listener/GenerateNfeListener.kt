package br.com.eliasjr.mercadolivro.event.listener

import br.com.eliasjr.mercadolivro.event.PurchaseEvent
import br.com.eliasjr.mercadolivro.service.PurchaseService
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import java.util.*

@Component
class GenerateNfeListener(
    private val purchaseService: PurchaseService
) {

    @EventListener
    fun listen(purchaseEvent: PurchaseEvent) {
        val nfe = UUID.randomUUID().toString()
        val purchaseModel = purchaseEvent.purchaseModel.copy(nfe = nfe)
        purchaseService.update(purchaseModel)
    }

}