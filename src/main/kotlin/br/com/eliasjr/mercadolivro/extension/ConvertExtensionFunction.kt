package br.com.eliasjr.mercadolivro.extension

import br.com.eliasjr.mercadolivro.controller.request.PostBookRequest
import br.com.eliasjr.mercadolivro.controller.request.PostCustomerRequest
import br.com.eliasjr.mercadolivro.controller.request.PutCustomerRequest
import br.com.eliasjr.mercadolivro.enums.BookStatus
import br.com.eliasjr.mercadolivro.model.BookModel
import br.com.eliasjr.mercadolivro.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}

fun PutCustomerRequest.toCustomerModel(id: Int): CustomerModel {
    return CustomerModel(id = id, name = this.name, email = this.email)
}

fun PostBookRequest.toBookModel(customerModel: CustomerModel) : BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ATIVO,
        customer = customerModel
    )
}