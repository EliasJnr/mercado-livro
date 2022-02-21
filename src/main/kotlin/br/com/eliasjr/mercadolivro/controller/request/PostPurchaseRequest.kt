package br.com.eliasjr.mercadolivro.controller.request

import com.fasterxml.jackson.annotation.JsonAlias
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

class PostPurchaseRequest(

    @field:NotNull
    @field:Positive
    @JsonAlias("customer_id")
    val costumerId: Int,

    @field:NotNull
    @JsonAlias("book_ids")
    val bookIds: Set<Int>

) {

}
