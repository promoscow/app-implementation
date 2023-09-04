package ru.xpendence.appimplementation.entity

import java.util.*

data class Cart(
    val id: UUID,
    val goods: Collection<Good>,
    val customer: Customer
)
