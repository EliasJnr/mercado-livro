package br.com.eliasjr.mercadolivro.enums

enum class Errors(val code: String, val message: String) {

    ML101("ML-1001", message = "Book [%s] not exists"),
    ML102("ML-102", "Cannot update book with status [%s]"),

    ML201("ML-1101", message = "Customer [%s] not exists")

}