package ru.xpendence.appimplementation.service

import ru.xpendence.appimplementation.entity.Payment
import ru.xpendence.appimplementation.entity.type.PaymentStatus
import java.util.*

interface PaymentService {

    fun create(payment: Payment): Payment

    fun updateStatus(id: UUID, status: PaymentStatus): Payment

    fun get(id: UUID): Payment

    fun getAll(orderId: UUID): List<Payment>
}