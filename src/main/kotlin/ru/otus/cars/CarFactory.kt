package ru.otus.cars

/**
 * Автозавод
 */
interface CarFactory {
    /**
     * Выпусти машину
     */
    fun buildCar(plates: Car.Plates): Car
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
        println(vaz)
        return vaz
    }

    override fun buildCar(plates: Car.Plates): Car {
        return buildVaz2107(plates)
    }
}