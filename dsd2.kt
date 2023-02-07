val contenedor = arrayOf<String>()
var titulo: String = ""
var usuario: String = ""
var email: String = ""
var contrasenia: String = ""
val creado = contenedor + titulo + usuario + email + contrasenia

fun creando() {
    println("Elige un titulo...")
    titulo = readLine()?.toString() as String
    println("Tu usuario...")
    usuario = readLine()?.toString() as String
    println("El email...")
    email = readLine()?.toString() as String
    println("Escribe la contraseña!")
    contrasenia = readLine()?.toString() as String
    println("Tu contraseña fue guardada con exito!")
}

fun eliminar() {
    titulo= ""
    usuario= ""
    email= ""
    contrasenia= ""
    println("Se elemino la contraseña guardada anteriormente")
}

fun mostrar() {
    println("Contraseña de $titulo")
    println("Usuario: $usuario")
    println("Email: $email")
    println("Contraseña: $contrasenia")
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
    println("Bienvenido a *****")
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

        }
        eleccion == 6 -> {

        }
    }

}