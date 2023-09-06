package ru.xpendence.appimplementation.repository

import ru.xpendence.appimplementation.entity.Good
import ru.xpendence.appimplementation.service.data.Filter
import java.util.*

interface GoodRepository {

    fun save(good: Good): Good

    fun update(good: Good): Good

    fun find(id: UUID): Good?

    fun findAll(filter: Filter): List<Good>

    fun delete(id: UUID)
}