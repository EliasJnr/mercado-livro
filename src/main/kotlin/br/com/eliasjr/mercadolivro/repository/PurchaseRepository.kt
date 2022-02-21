package br.com.eliasjr.mercadolivro.repository

import br.com.eliasjr.mercadolivro.model.PurchaseModel
import org.springframework.data.repository.CrudRepository

interface PurchaseRepository : CrudRepository<PurchaseModel, Int> {

}
