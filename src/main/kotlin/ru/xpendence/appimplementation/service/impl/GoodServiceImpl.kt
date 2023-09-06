package ru.xpendence.appimplementation.service.impl

import org.springframework.stereotype.Service
import ru.xpendence.appimplementation.entity.Good
import ru.xpendence.appimplementation.repository.GoodRepository
import ru.xpendence.appimplementation.service.GoodService
import ru.xpendence.appimplementation.service.data.Filter
import java.util.*

@Service
class GoodServiceImpl(
    private val repository: GoodRepository
) : GoodService {

    override fun create(good: Good): Good = repository.save(good)

    override fun update(good: Good): Good = repository.update(good)

    override fun get(id: UUID): Good = repository.find(id)
        ?: throw IllegalArgumentException("Good nor found by id: $id")

    override fun getAll(filter: Filter): List<Good> = repository.findAll(filter)

    override fun delete(id: UUID) {
        repository.delete(id)
    }
}