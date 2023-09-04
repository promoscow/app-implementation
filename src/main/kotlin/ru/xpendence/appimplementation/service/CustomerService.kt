package ru.xpendence.appimplementation.service

import ru.xpendence.appimplementation.entity.Customer
import java.util.*

interface CustomerService {

    fun create(customer: Customer): Customer

    fun get(id: UUID): Customer
}
