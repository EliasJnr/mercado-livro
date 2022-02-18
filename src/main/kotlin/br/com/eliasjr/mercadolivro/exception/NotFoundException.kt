package br.com.eliasjr.mercadolivro.exception

class NotFoundException(override val message: String, val errorCode: String): Exception() {


}