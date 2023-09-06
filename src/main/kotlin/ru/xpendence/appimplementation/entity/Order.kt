package ru.xpendence.appimplementation.entity

import ru.xpendence.appimplementation.entity.type.OrderStatus
import java.util.*

data class Order(
    val id: UUID? = null,
    val status: OrderStatus,
    val goods: Collection<Good>,
    val payments: List<Payment>? = null,
    val customer: Customer
)
