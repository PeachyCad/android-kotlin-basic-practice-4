package ru.otus.cars

fun main() {
    driveCars()
}

fun driveCars() {
    val vaz1: Car = Vaz2107(Car.Plates("123", 77))
    val vaz2: Car = Vaz2107(Car.Plates("321", 78))

    println("Экземпляры класса имеют разное внутреннее состояние:")
    vaz1.wheelToRight(10)
    println(vaz1.toString()) // Выводит 10
    vaz2.wheelToLeft(20)
    println(vaz2.toString()) // Выводит -20
}