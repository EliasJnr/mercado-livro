package br.com.eliasjr.mercadolivro.extension

import br.com.eliasjr.mercadolivro.controller.request.PostCustomerRequest
import br.com.eliasjr.mercadolivro.controller.request.PutCustomerRequest
import br.com.eliasjr.mercadolivro.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}

fun PutCustomerRequest.toCustomerModel(id: String): CustomerModel {
    return CustomerModel(id = id, name = this.name, email = this.email)
}