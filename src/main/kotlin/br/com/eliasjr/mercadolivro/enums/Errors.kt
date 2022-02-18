package br.com.eliasjr.mercadolivro.enums

enum class Errors(val code: String, val message: String) {

    ML101("ML-1001", message = "Book [%s] not exists"),
    ML201("ML-1101", message = "Customer [%s] not exists")

}