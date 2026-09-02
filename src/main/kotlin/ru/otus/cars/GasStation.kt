package ru.otus.cars

/**
 * Заправка. Одна на всех - поэтому object.
 */
object GasStation {
    /**
     * Стандартная порция топлива
     */
    const val DEFAULT_LITERS = 40

    /**
     * Заправить машину [liters] литрами.
     * Метод залива выбирается по горловине, взрыв бака обрабатывается.
     */
    fun refuel(car: Car, liters: Int = DEFAULT_LITERS) {
        val mouth = car.tankMouth
        mouth.open()
        try {
            // when по sealed-иерархии: else не нужен
            when (mouth) {
                is PetrolMouth -> {
                    println("Наливаем $liters л бензина...")
                    mouth.fuelPetrol(liters)
                }
                is LpgMouth -> {
                    println("Качаем $liters л газа...")
                    mouth.fuelLpg(liters)
                }
            }
        } catch (e: TankExplodedException) {
            println("ЧП на заправке: ${e.message}")
        } finally {
            // Крышку закрываем в любом случае - даже если бак рванул
            mouth.close()
        }
    }
}

/**
 * Заправить сразу всю коллекцию машин
 */
fun Iterable<Car>.refuelAll(liters: Int = GasStation.DEFAULT_LITERS) = forEach { car -> GasStation.refuel(car, liters) }
