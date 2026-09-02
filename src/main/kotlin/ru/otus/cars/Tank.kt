package ru.otus.cars

/**
 * Бак машины. Наружу торчит только этот интерфейс —
 * реализация спрятана внутри файла.
 */
interface Tank {
    /**
     * Горловина, установленная на баке.
     * Она определяет, что именно в бак заливают.
     */
    val mouth: TankMouth

    /**
     * Сколько топлива сейчас в баке
     */
    fun getContents(): Int

    /**
     * Принять топливо. Вызывается горловиной, а не водителем.
     */
    fun receiveFuel(liters: Int)

    /**
     * Специалист по топливным системам: только он умеет собрать бак с горловиной.
     */
    companion object Assembler {
        /**
         * Приварить бензиновую горловину к любому баку
         */
        fun petrolMouthFor(tank: Tank): TankMouth = PetrolMouth(tank)

        /**
         * Приварить газовую горловину к любому баку
         */
        fun lpgMouthFor(tank: Tank): TankMouth = LpgMouth(tank)

        /**
         * Бак под бензин
         */
        fun assemblePetrolSystem(): Tank = FuelTank().apply { mouth = petrolMouthFor(this) }

        /**
         * Бак под сжиженный газ
         */
        fun assembleLpgSystem(): Tank = FuelTank().apply { mouth = lpgMouthFor(this) }
    }
}

/**
 * Реализация бака.
 * private на уровне файла: за пределами Tank.kt этого класса просто не существует.
 */
private class FuelTank : Tank {
    // Текущий запас топлива
    private var contents: Int = 0

    // Горловину ставит сборщик сразу после создания бака
    override lateinit var mouth: TankMouth

    override fun getContents(): Int = contents

    override fun receiveFuel(liters: Int) {
        contents += liters
    }
}

/**
 * Бак не выдержал заправки
 */
class TankExplodedException(message: String) : RuntimeException(message)
