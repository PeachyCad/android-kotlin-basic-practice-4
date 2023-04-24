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
    private val vaz2107Builder = Vaz2107.Builder()

    private fun buildVaz2107(plates: Car.Plates): Car {
        println("Запил Жигулей в Тольятти...")
        val vaz = vaz2107Builder.build(plates)
        println("Проверяем тачку...")
        vaz2107Builder.test(vaz)
        println(vaz)
        return vaz
    }

    override fun buildCar(plates: Car.Plates): Car {
        return buildVaz2107(plates)
    }
}