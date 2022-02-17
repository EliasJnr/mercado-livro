package br.com.eliasjr.mercadolivro.controller.request

data class PutCustomerRequest(
    var name: String,
    var email: String
)