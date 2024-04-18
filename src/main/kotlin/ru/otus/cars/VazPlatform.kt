package ru.otus.cars

abstract class VazPlatform(override val color: String) : Car {
    // Положение руля. Доступно только внутри класса и наследникам
    protected var wheelAngle: Int = 0 // Положение руля

    // Реализация интерфейса CarInput
    override fun wheelToRight(degrees: Int) { wheelAngle += degrees }
    // Реализация интерфейса CarInput
    override fun wheelToLeft(degrees: Int) { wheelAngle -= degrees }

    // Получить оборудование
    override fun getEquipment(): String = "Кузов, колеса, движок"

    // Абстрактное свойство двигателя
    abstract val engine: VazEngine
}

// Перечисление двигателей ВАЗ
// Объем двигателя определен раз и навсегда
enum class VazEngine(val volume: Int) {
    LADA_2107(1_600), SAMARA_2108(1_300)
}