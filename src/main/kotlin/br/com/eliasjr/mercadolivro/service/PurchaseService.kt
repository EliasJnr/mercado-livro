package br.com.eliasjr.mercadolivro.service

import br.com.eliasjr.mercadolivro.event.PurchaseEvent
import br.com.eliasjr.mercadolivro.model.PurchaseModel
import br.com.eliasjr.mercadolivro.repository.PurchaseRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class PurchaseService(
    private val purchaseRepository: PurchaseRepository,
    private val applcationEventPublisher: ApplicationEventPublisher
) {

    fun create(purchaseModel: PurchaseModel) {
        purchaseRepository.save(purchaseModel)

        println("disparando evento de compra")
        applcationEventPublisher.publishEvent(PurchaseEvent(this, purchaseModel))
        println("finalização do processamento")

    }

    fun update(purchaseModel: PurchaseModel) {
        purchaseRepository.save(purchaseModel)
    }


}
