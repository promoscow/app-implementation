package ru.xpendence.appimplementation.entity

import java.util.*

data class Customer(
    val id: UUID,
    val name: String,
    val cart: Cart,
    val orders: Collection<Order>
)