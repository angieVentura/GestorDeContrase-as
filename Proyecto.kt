fun generatePassword(): String {
    var change: Int? = null
    change = 1
    while (change == 1) {
        val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9') + listOf('!', '@', '#', '$', '%', '^', '&', '*')
        val password = (1..8)
            .map { i -> kotlin.random.Random.nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString("")
        println(password)
        println("Si quiere generar otra contraseña ingrese el número 1, sino ingrese 0.")
        change = readLine()?.toInt()
    }
    return ""
}

fun main() {
    println("Hola, si quieres almacenar una contraseña ingresa el número 1 o si quieres generar una contraseña segura ingresa el número 2.")
    var num: Int? = null
    num = readLine()?.toInt()
    if (num == 2){
        generatePassword()
    }
}