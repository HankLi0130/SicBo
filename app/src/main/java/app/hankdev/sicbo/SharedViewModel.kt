package app.hankdev.sicbo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.hankdev.sicbo.model.Condition
import app.hankdev.sicbo.model.Round

class SharedViewModel : ViewModel() {

    private val rounds: MutableList<Round> = mutableListOf()

    private val _roundsData = MutableLiveData<List<Round>>()
    val roundsData: LiveData<List<Round>> get() = _roundsData

    fun addRound(diceNumbers: IntArray) {
        val sum = diceNumbers.sum()
        val condition = when (sum) {
            in 4..10 -> Condition.SMALL
            in 11..17 -> Condition.BIG
            else -> Condition.KILLING
        }
        val round = Round(diceNumbers, sum, condition)
        addRound(round)
    }

    fun addRound(round: Round) {
        rounds.add(round)
        updateRoundsData()
    }

    fun removeRound(round: Round) {
        rounds.remove(round)
        updateRoundsData()
    }

    fun removeAllRounds() {
        rounds.clear()
        updateRoundsData()
    }

    private fun updateRoundsData() {
        _roundsData.value = rounds
    }
}