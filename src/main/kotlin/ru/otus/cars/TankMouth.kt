package ru.otus.cars

/**
 * Горловина бака: через неё машина заправляется.
 * Sealed: набор видов горловин закрыт и известен компилятору.
 */
sealed class TankMouth(private val tank: Tank) {
    private var isOpen = false

    fun open() { isOpen = true }

    fun close() { isOpen = false }

    /**
     * Общая механика залива: доступна только наследникам.
     */
    protected fun pour(liters: Int) {
        check(isOpen) { "Горловина закрыта" }
        tank.receiveFuel(liters)
    }
}

/**
 * Бензиновая горловина: принимает только бензин.
 */
class PetrolMouth(tank: Tank) : TankMouth(tank) {
    fun fuelPetrol(liters: Int) = pour(liters)
}

/**
 * Газовая горловина: принимает только сжиженный газ.
 */
class LpgMouth(tank: Tank) : TankMouth(tank) {
    fun fuelLpg(liters: Int) = pour(liters)
}
