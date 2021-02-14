package dev.hankli.sicbo

import dev.hankli.sicbo.model.Condition
import tw.hankli.brookray.core.constant.NO_RESOURCE

fun getDiceRes(number: Int): Int {
    return when (number) {
        1 -> R.drawable.ic_dice_one
        2 -> R.drawable.ic_dice_two
        3 -> R.drawable.ic_dice_three
        4 -> R.drawable.ic_dice_four
        5 -> R.drawable.ic_dice_five
        6 -> R.drawable.ic_dice_six
        else -> NO_RESOURCE
    }
}

fun getConditionRes(condition: Condition): Int {
    return when (condition) {
        Condition.BIG -> R.string.big
        Condition.SMALL -> R.string.small
        Condition.KILLING -> R.string.killing
    }
}