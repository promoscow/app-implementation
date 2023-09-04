package ru.xpendence.appimplementation.service

import ru.xpendence.appimplementation.entity.Order
import java.util.*

interface OrderService {

    fun create(order: Order): Order

    fun update(order: Order): Order

    fun get(id: UUID): Order

    fun getAll(customerId: UUID): List<Order>

    fun delete(id: UUID)
}