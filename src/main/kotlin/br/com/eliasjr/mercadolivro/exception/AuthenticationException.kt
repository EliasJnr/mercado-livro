package br.com.eliasjr.mercadolivro.exception

class AuthenticationException(override val message: String, val errorCode: String) : Exception() {
}