package dev.hankli.sicbo.model

data class Round(
    val diceGroup: List<Dice>,
    val sum: Int,
    val condition: Condition
)
