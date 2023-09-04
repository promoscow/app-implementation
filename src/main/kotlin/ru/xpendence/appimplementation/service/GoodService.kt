package ru.xpendence.appimplementation.service

import ru.xpendence.appimplementation.entity.Good
import ru.xpendence.appimplementation.service.data.Filter
import java.util.*

interface GoodService {

    fun create(good: Good): Good

    fun update(good: Good): Good

    fun get(id: UUID): Good

    fun getAll(filter: List<Filter>): List<Good>

    fun delete(id: UUID)
}