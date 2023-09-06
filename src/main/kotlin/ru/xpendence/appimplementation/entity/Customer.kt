package ru.xpendence.appimplementation.entity

import java.util.*

data class Customer(
    val id: UUID? = null,
    val name: String,
    val cart: Cart,
    val orders: Collection<Order>? = null
)