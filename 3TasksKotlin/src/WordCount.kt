package WordCount

    fun phrase(input: String): Map<String, Int> =
        input
            .toLowerCase()
            .split(Regex("[^A-Za-z0-9']"))
            .filterNot {it.isBlank()}
            .map { it.removeSurrounding("'")}
            .groupingBy { it }
            .eachCount()
