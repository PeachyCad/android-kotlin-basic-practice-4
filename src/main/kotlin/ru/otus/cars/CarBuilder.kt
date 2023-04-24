package ru.otus.cars

/**
 * Сборщик машины
 */
interface CarBuilder {
    /**
     * Собери машину
     */
    fun build(plates: Car.Plates): Car
}