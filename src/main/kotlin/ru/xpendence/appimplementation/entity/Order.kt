package ru.xpendence.appimplementation.entity

import ru.xpendence.appimplementation.entity.type.OrderStatus
import java.util.*

data class Order(
    val id: UUID,
    val status: OrderStatus,
    val goods: Collection<Good>,
    val payments: List<Payment>?,
    val customer: Customer
)
