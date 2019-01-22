class IsbnVerifier {
    fun isValid(input: String): Boolean =
            input
                .toLowerCase()
                .replace("-", "")
                .apply { if (length != 10) return false }
                .apply { if (!Regex("""^[\d]+x?""").matches(this)) return false }
                .split("")
                .filter { !it.isBlank() }
                .map {if(it == "x") 10 else it.toInt() }
                .mapIndexed { idx, it -> (10 - idx) * it }
                .sum() % 11 == 0
}