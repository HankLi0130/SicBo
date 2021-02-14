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

fun getConditionStringRes(condition: Condition): Int {
    return when (condition) {
        Condition.SMALL -> R.string.small
        Condition.BIG -> R.string.big
        Condition.KILLING -> R.string.killing
    }
}

fun getConditionColorRes(condition: Condition): Int {
    return when (condition) {
        Condition.SMALL -> R.color.md_green_900
        Condition.BIG -> R.color.md_red_900
        Condition.KILLING -> R.color.md_yellow_A700
    }
}