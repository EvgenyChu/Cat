package first2.cats

fun main () {
    val names = listOf(
        "Serega",
        "Boris",
        "Pushok",
        "Murzik",
        "Motfey",
        "Obzhora",
        "Tom",
        "Prince",
        "Sam",
        "Shmit"
    )
    val cats = names.map{Cat.makeCat(it)}
    for (i in 0..9) {
        println("current step ${i.inc()}")
        cats.forEach { it.move(cats) }

    }
}
