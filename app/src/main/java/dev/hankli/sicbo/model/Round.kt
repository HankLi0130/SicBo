package dev.hankli.sicbo.model

data class Round(
    val diceNumbers: IntArray,
    val sum: Int,
    val condition: Condition
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Round

        if (!diceNumbers.contentEquals(other.diceNumbers)) return false
        if (sum != other.sum) return false
        if (condition != other.condition) return false

        return true
    }

    override fun hashCode(): Int {
        var result = diceNumbers.contentHashCode()
        result = 31 * result + sum
        result = 31 * result + condition.hashCode()
        return result
    }
}
