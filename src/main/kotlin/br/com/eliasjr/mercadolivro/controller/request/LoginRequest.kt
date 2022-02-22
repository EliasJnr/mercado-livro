package br.com.eliasjr.mercadolivro.controller.request

data class LoginRequest(
    val email: String,
    val password: String
) {
}