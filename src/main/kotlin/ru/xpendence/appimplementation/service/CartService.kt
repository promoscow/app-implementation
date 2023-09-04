package ru.xpendence.appimplementation.service

import ru.xpendence.appimplementation.entity.Cart
import java.util.*

interface CartService {

    fun createByCustomer(customerId: UUID): Cart
}