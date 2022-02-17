package br.com.eliasjr.mercadolivro.controller.response

import br.com.eliasjr.mercadolivro.enums.CustomerStatus

data class CustomerResponse(
    var id: Int? = null,

    var name: String,

    var email: String,

    var status: CustomerStatus
) {


}
