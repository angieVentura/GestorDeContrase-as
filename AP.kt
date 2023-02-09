val list = mutableListOf<Triple<String, String, Pair<String, String>>>()

fun creando() {

    var count = 0
        var change: Int? = null
        change = 1
        while (change == 1) {
            println("Ingrese un título:")
            val title = readLine()!!

            println("Ingrese un usuario:")
            val username = readLine()!!

            println("Ingrese un correo electrónico:")
            val email = readLine()!!

            println("Ingrese una contraseña:")
            val password = readLine()!!

            list.add(Triple(title, username, email to password))
            count++

            println("Si quiere generar otro registro ingrese el número 1, sino ingrese 0.")
            change = readLine()?.toInt()
        }

    val startIndex = list.size - 10.coerceAtMost(count)
    for (i in startIndex until list.size) {
        println("Título: ${list[i].first}")
        println("Usuario: ${list[i].second}")
        println("Correo electrónico: ${list[i].third.first}")
        println("Contraseña: ${list[i].third.second}")
        println()
    }

}

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

fun eliminar() {
    if (list.isEmpty()) {
        println("No hay contraseñas para eliminar")
        return
    } else {
        for ((index, triple) in list.withIndex()) {
            println("$index. Título: ${triple.first}")
        }
        println("Ingrese el número del registro que desea eliminar (o ingrese -1 para salir):")
        val input = readLine()!!.toInt()
        if (input >= 0 && input < list.size) {
            list.removeAt(input)
        } else if (input != -1) {
            println("Entrada inválida.")
        }
    }
}


fun mostrar() {
    if (list.isEmpty()) {
        println("No hay contraseñas para mostrar")
        return
    } else {
        for (triple in list) {
            println("Título: ${triple.first}")
            println("Usuario: ${triple.second}")
            println("Correo electrónico: ${triple.third.first}")
            println("Contraseña: ${triple.third.second}")
            println()
        }
    }

}

fun pregunta() {
    println(" ")
    println("Quieres volver al inicio?")
    println("Escribe si o no")
    var eleccion = readLine()?.toString() as String
    when {
        eleccion == "si" -> return main()
        eleccion == "no" -> println("Haz salido del programa")
        else -> {
            println("Asegurate de escribirlo igual a como te lo preguntamos")
            return pregunta()
        }
    }
}

fun aboutAs(){
    println("""
          Somos un grupo de estudiantes de la plataforma Aprende Programando. Nuestro objetivo es facilitar
          la vida de aquellos que posean cuentas y no puedan recordar sus contraseñas. Añadiendo un generador
          de contraseñas que cumpla con los requisitos que necesites.
    """.trimIndent())
}

fun help(){
    println("Si necesitas ayuda manda un mail a PASSWORDblue@gmail.com")
}

fun main() {
   /**/ println("Bienvenido a PASSWORDblue")
    println("Tu protector de contraseñas!")
    println("Di (1) si quieres guardar una contraseña")
    println("Di (2) si quieres eliminar una contraseña")
    println("Di (3) si quieres ver una contraseña")
    println("Di (4) si quieres generar una contraseña")
    println("Di (5) si quieres saber de nosotros")
    println("Di (6) si necesitas ayuda")
    var eleccion = readLine()?.toInt() as Int
    when {
        eleccion == 1 -> {
            creando()
            pregunta()
        }
        eleccion == 2 -> {
            eliminar()
            pregunta()
        }
        eleccion == 3 -> {
            mostrar()
            pregunta()
        }
        eleccion == 4 -> {
            generatePassword()
            pregunta()
        }
        eleccion == 5 -> {
            aboutAs()
            pregunta()
        }
        eleccion == 6 -> {
            help()
            pregunta()
        }
    }

}