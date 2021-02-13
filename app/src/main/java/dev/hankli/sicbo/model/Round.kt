package dev.hankli.sicbo.model

data class Round(
    val roundNumber: Int,
    val diceGroup: List<Dice>,
    val sum: Int,
    val condition: Condition
)
