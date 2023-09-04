package ru.xpendence.appimplementation.entity

import java.math.BigDecimal
import java.util.*

data class Good(
    val id: UUID,
    val name: String,
    val price: BigDecimal,
    val carts: Collection<Cart>
)