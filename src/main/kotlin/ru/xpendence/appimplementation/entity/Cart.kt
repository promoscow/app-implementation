package ru.xpendence.appimplementation.entity

import java.util.*

data class Cart(
    val id: UUID? = null,
    val goods: Collection<Good>? = null,
    val customer: Customer
)
