package ru.otus.cars

object Taz: Car {
    /**
     * Номерной знак
     */
    override val plates: Car.Plates
        get() = throw NotImplementedError("Номера сняты")

    /**
     * Цвет машины
     */
    override val color: String = "Ржавый"

    /**
     * Следит за машиной
     */
    override val carOutput: CarOutput
        get() = throw NotImplementedError("Приборов нет")

    /**
     * Горловина есть, а бак лучше не трогать
     */
    override val tankMouth: TankMouth
        get() = RustyTank.mouth

    /**
     * Получить оборудование
     */
    override fun getEquipment(): String = "Крыса"

    /**
     * Руль вправо на [degrees] градусов
     */
    override fun wheelToRight(degrees: Int) {
        throw NotImplementedError("Руля нет")
    }

    /**
     * Руль влево на [degrees] градусов
     */
    override fun wheelToLeft(degrees: Int) {
        throw NotImplementedError("Руля нет")
    }

    // Выводим состояние машины
    override fun toString(): String = "Taz(color=$color, fuel=${RustyTank.getContents()})"

    /**
     * Ржавый бак ТАЗа. Вложенный private object: снаружи о нём никто не знает.
     */
    private object RustyTank : Tank {
        // Горловину и ТАЗу ставит специалист
        override val mouth: TankMouth = Tank.petrolMouthFor(this)

        override fun getContents(): Int = 0

        override fun receiveFuel(liters: Int) {
            throw TankExplodedException("Бак ТАЗа взорвался при заправке!")
        }
    }
}
