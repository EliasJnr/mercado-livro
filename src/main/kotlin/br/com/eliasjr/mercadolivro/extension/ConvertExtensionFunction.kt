package br.com.eliasjr.mercadolivro.extension

import br.com.eliasjr.mercadolivro.controller.request.PostBookRequest
import br.com.eliasjr.mercadolivro.controller.request.PostCustomerRequest
import br.com.eliasjr.mercadolivro.controller.request.PutBookRequest
import br.com.eliasjr.mercadolivro.controller.request.PutCustomerRequest
import br.com.eliasjr.mercadolivro.enums.BookStatus
import br.com.eliasjr.mercadolivro.enums.CustomerStatus
import br.com.eliasjr.mercadolivro.model.BookModel
import br.com.eliasjr.mercadolivro.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email, status = CustomerStatus.ATIVO)
}

fun PutCustomerRequest.toCustomerModel(previousValue: CustomerModel): CustomerModel {
    return CustomerModel(id = previousValue.id, name = this.name, email = this.email, status = previousValue.status)
}

fun PostBookRequest.toBookModel(customerModel: CustomerModel): BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ATIVO,
        customer = customerModel
    )
}

fun PutBookRequest.toBookModel(previousValue: BookModel): BookModel {
    return BookModel(
        id = previousValue.id,
        name = this.name ?: previousValue.name,
        price = this.price ?: previousValue.price,
        status = previousValue.status,
        customer = previousValue.customer
    )
}