package com.stone.desafio.model

data class Customer(
    var name: String? = null,
    var id: String? = null,
    var status: String? = null,
    var description: String? = null,
    var alert: Boolean = false
)