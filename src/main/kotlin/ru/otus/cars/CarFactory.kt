package ru.otus.cars

/**
 * Автозавод
 */
interface CarFactory {
    /**
     * Выпусти машину
     */
    fun buildCar(builder: CarBuilder, plates: Car.Plates): Car
}

/**
 * Автозавод в Тольятти (он у нас один такой)
 */
object Togliatti : CarFactory {
    private fun buildVaz2107(plates: Car.Plates): Car {
        println("Запил ${Vaz2107.MODEL} в Тольятти...")
        val vaz = Vaz2107.build(plates)
        println("Проверяем тачку...")
        Vaz2107.test(vaz)
        vaz.drdrdrdrdr()
        return vaz
    }

    private fun buildVaz2108(plates: Car.Plates): Car {
        println("Запил ${Vaz2108.MODEL} в Тольятти...")
        val vaz = Vaz2108.build(plates)
        println("Сход-развал...")
        Vaz2108.alignWheels(vaz)
        vaz.zhzhzhzh()
        return vaz
    }

    override fun buildCar(builder: CarBuilder, plates: Car.Plates): Car {
        return when (builder) {
            is Vaz2107.Companion -> return buildVaz2107(plates)
            is Vaz2108.Companion -> return buildVaz2108(plates)
        }
    }
}