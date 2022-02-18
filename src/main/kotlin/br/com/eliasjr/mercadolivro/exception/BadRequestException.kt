package br.com.eliasjr.mercadolivro.exception

class BadRequestException(override val message: String, val errorCode: String): Exception() {


}