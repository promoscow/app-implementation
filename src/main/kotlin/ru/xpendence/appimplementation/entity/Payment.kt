package ru.xpendence.appimplementation.entity

import ru.xpendence.appimplementation.entity.type.PaymentStatus
import java.util.*

data class Payment(
    val id: UUID,
    val status: PaymentStatus,
    val order: Order
)
