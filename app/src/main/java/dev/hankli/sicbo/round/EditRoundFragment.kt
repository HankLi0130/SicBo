package dev.hankli.sicbo.round

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import dev.hankli.sicbo.R
import dev.hankli.sicbo.SharedViewModel
import dev.hankli.sicbo.databinding.FragmentEditRoundBinding
import dev.hankli.sicbo.getDiceRes
import tw.hankli.brookray.core.constant.ZERO

class EditRoundFragment : Fragment(R.layout.fragment_edit_round) {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    private var _binding: FragmentEditRoundBinding? = null
    private val binding get() = _binding!!

    private val selectedDice = IntArray(3)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditRoundBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.firstDice.setOnClickListener { removeSelectedDiceNumber(0) }
        binding.secondDice.setOnClickListener { removeSelectedDiceNumber(1) }
        binding.thridDice.setOnClickListener { removeSelectedDiceNumber(2) }

        binding.diceOne.setOnClickListener { selectDiceNumber(1) }
        binding.diceTwo.setOnClickListener { selectDiceNumber(2) }
        binding.diceThree.setOnClickListener { selectDiceNumber(3) }
        binding.diceFour.setOnClickListener { selectDiceNumber(4) }
        binding.diceFive.setOnClickListener { selectDiceNumber(5) }
        binding.diceSix.setOnClickListener { selectDiceNumber(6) }

        binding.submit.setOnClickListener {
            selectedDice.sort()
            sharedViewModel.addRound(selectedDice)
            findNavController().popBackStack()
        }
    }

    private fun selectDiceNumber(number: Int) {
        for ((index, dice) in selectedDice.withIndex()) {
            if (dice == ZERO) {
                selectedDice[index] = number
                updateUI()
                return
            }
        }
    }

    private fun removeSelectedDiceNumber(index: Int) {
        selectedDice[index] = ZERO
        updateUI()
    }

    private fun updateUI() {
        binding.firstDice.setImageResource(getDiceRes(selectedDice[0]))
        binding.secondDice.setImageResource(getDiceRes(selectedDice[1]))
        binding.thridDice.setImageResource(getDiceRes(selectedDice[2]))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}