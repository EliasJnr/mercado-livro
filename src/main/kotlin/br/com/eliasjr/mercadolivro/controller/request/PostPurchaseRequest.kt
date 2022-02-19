package br.com.eliasjr.mercadolivro.controller.request

import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

class PostPurchaseRequest(

    @field:NotNull
    @field:Positive
    val costumerId: Int,

    @field:NotNull
    val bookIds: Set<Int>

) {

}
