package first2.cats

class Cat(
    val name: String,
    var position: Pair<Int, Int>

) {
    val age: Int
    val color: CatColor

    init {
        age = (1..15).random()
        val rnd = (0..3).random()
        color = CatColor.values()[rnd]
        println(" cat $name $age color: $color $position")
    }

    companion object {
        val reservedPosition: MutableList<Pair<Int, Int>> = mutableListOf()
        fun makeCat(name: String): Cat {
            val x = (0..9).random()
            val y = (0..9).random()
            val newPosition = x to y
            if (reservedPosition.contains(newPosition)) {
                println("position reserved $newPosition in $reservedPosition")
                return makeCat(name)
            } else {
                reservedPosition.add(newPosition)
                return Cat(name, newPosition)
            }
        }
    }

    fun move(cats: List<Cat>) {
        val a = (0..3).random()
        val direction = Direction.values()[a]
        val oldPosition = position.copy()

        when (direction) {

            Direction.UP -> {
                if (oldPosition.second > -1 && oldPosition.second < 9) {
                    position = position.copy(second = position.second + 1)
                    println("cat $name move from $oldPosition in $position $direction")
                } else {
                    position = oldPosition
                    println("cat $name move from $oldPosition do $direction and say Mau")
                }

            }
            Direction.RIGHT -> {
                if (oldPosition.first > -1 && oldPosition.first < 9) {
                    position = position.copy(first = position.first + 1)
                    println("cat $name move from $oldPosition in $position $direction")
                } else {
                    position = oldPosition
                    println("cat $name move from $oldPosition do $direction and say Mau")
                }
            }
            Direction.LEFT -> {
                if (oldPosition.first > 0 && oldPosition.first < 10) {
                    position = position.copy(first = position.first - 1)
                    println("cat $name move from $oldPosition in $position $direction")
                } else {
                    position = oldPosition
                    println("cat $name move from $oldPosition do $direction and say Mau")
                }
            }
            Direction.DOWN -> {
                if (oldPosition.second > 0 && oldPosition.second < 10) {
                    position = position.copy(second = position.second - 1)
                    println("cat $name move from $oldPosition in $position $direction")
                } else {
                    position = oldPosition
                    println("cat $name move from $oldPosition do $direction and say Mau")
                }
            }

        }
        val evilCat = cats.find { (it.position == position) && (it.name != name) }

        if (evilCat != null) {
            hises(evilCat.name)
            move(cats)
            evilCat.hises(name)
            evilCat.move(cats)
        }

    }
    fun hises (otherCatName: String) {
        println("Cat $name say hisess on $otherCatName in $position")
    }
}