package ru.otus.cars

abstract class VazPlatform : Car {
    protected var wheelAngle: Int = 0 // Положение руля

    override fun wheelToRight(degrees: Int) { wheelAngle += degrees }

    override fun wheelToLeft(degrees: Int) { wheelAngle -= degrees }
}