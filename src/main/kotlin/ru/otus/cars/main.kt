package ru.otus.cars

fun main() {
    println("===> drive cars...")
    driveCars()
    println("===> inner test...")
    innerNestedCheck()
}

fun driveCars() {
    val builder: Vaz2107.Builder = Vaz2107.Builder()
    val vaz1 = builder.build(Car.Plates("123", 77))
    val vaz2 = builder.build(Car.Plates("321", 78))

    // Проверочка...
    builder.test(vaz1)
    builder.test(vaz2)

    println("Экземпляры класса имеют разное внутреннее состояние:")
    vaz1.wheelToRight(10)
    println(vaz1.toString()) // Выводит 10 и случайную скорость
    vaz2.wheelToLeft(20)
    println(vaz2.toString()) // Выводит -20 и случайную скорость
}

fun innerNestedCheck() {
    val builder = Vaz2107.Builder()
    val vaz = builder.build(Car.Plates("123", 77))
    val output = vaz.VazOutput() // Создаем новый объект ИЗ ЭКЗЕМПЛЯРА МАШИНЫ

    println("Скорость до проверки: ${output.getCurrentSpeed()}") // Выводит 0
    builder.test(vaz) // Газуем...
    println("Скорость после проверки: ${output.getCurrentSpeed()}") // Выводит случайную скорость
}