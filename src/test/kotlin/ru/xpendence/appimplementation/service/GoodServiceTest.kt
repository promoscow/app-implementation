package ru.xpendence.appimplementation.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.xpendence.appimplementation.entity.Good
import ru.xpendence.appimplementation.service.data.Filter
import java.math.BigDecimal

@SpringBootTest
class GoodServiceTest {

    @Autowired
    private lateinit var goodService: GoodService

    @Test
    fun create() {
        //prepare
        val name = "someName"
        val price = BigDecimal.TEN
        val good = Good(
            name = name,
            price = price
        )

        //when
        val created = goodService.create(good)

        //then
        assertNotNull(created.id)
        assertEquals(name, created.name)
        assertEquals(price, created.price)

        //tear down
        goodService.delete(created.id!!)
    }

    @Test
    fun update() {
        //prepare
        val name = "someName"
        val price = BigDecimal.TEN
        val good = Good(
            name = name,
            price = price
        )
            .let { goodService.create(it) }

        //when
        val nameToUpdate = "someName2"
        val priceToUpdate = BigDecimal.ONE
        val updated =
            good.copy(price = priceToUpdate, name = nameToUpdate)
                .let { goodService.update(it) }

        //then
        assertEquals(nameToUpdate, updated.name)
        assertEquals(priceToUpdate, updated.price)

        //tear down
        goodService.delete(good.id!!)
    }

    @Test
    fun delete() {
        //prepare
        val name = "someName"
        val price = BigDecimal.TEN
        val good = Good(
            name = name,
            price = price
        )
            .let { goodService.create(it) }

        //when
        goodService.delete(good.id!!)

        //then
        assertThrows<IllegalArgumentException> { goodService.get(good.id!!) }

        //tear down
        goodService.delete(good.id!!)
    }

    @Test
    fun get() {
        //prepare
        val name = "someName"
        val price = BigDecimal.TEN
        val good = Good(
            name = name,
            price = price
        )
            .let { goodService.create(it) }

        //when
        //then
        assertDoesNotThrow { goodService.get(good.id!!) }

        //tear down
        goodService.delete(good.id!!)
    }

    @Test
    fun getAll() {
        //prepare
        val name = "someName"
        val price = BigDecimal.TEN
        Good(name = name, price = price)
            .also { goodService.create(it) }
        val filter = Filter(maxPrice = BigDecimal.TEN.inc())

        //when
        goodService.getAll(filter)
            .also {
                //then
                assertEquals(1, it.size)
                assertEquals(BigDecimal.TEN, it[0].price)
            }
    }
}