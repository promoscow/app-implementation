package ru.xpendence.appimplementation.repository.impl

import org.springframework.stereotype.Repository
import ru.xpendence.appimplementation.entity.Good
import ru.xpendence.appimplementation.repository.GoodRepository
import ru.xpendence.appimplementation.service.data.Filter
import java.util.*

@Repository
class GoodRepositoryMock : GoodRepository {

    val goods = mutableMapOf<UUID, Good>()

    override fun save(good: Good): Good = good.copy(id = UUID.randomUUID()).also { goods[it.id!!] = it }

    override fun update(good: Good): Good = good.also { goods[good.id!!] = good }

    override fun find(id: UUID): Good? = goods[id]

    override fun findAll(filter: Filter): List<Good> = goods.filter { it.value.price < filter.maxPrice }.values.toList()

    override fun delete(id: UUID) {
        goods.remove(id)
    }
}