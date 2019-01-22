package Isogram

    fun isIsogram(input: String): Boolean =
        input
             .filter { it.isLetter() }
             .toLowerCase()
             .groupingBy { it }
             .eachCount()
             .values
             .none { it > 1 }