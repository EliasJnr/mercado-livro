package br.com.eliasjr.mercadolivro.service

import br.com.eliasjr.mercadolivro.model.PurchaseModel
import br.com.eliasjr.mercadolivro.repository.PurchaseRepository
import org.springframework.stereotype.Service

@Service
class PurchaseService(
    private val purchaseRepository: PurchaseRepository
) {

    fun create(purchaseModel: PurchaseModel) {
        purchaseRepository.save(purchaseModel)
    }

}
