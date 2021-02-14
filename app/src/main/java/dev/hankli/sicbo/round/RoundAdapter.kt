package dev.hankli.sicbo.round

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.hankli.sicbo.databinding.ItemRoundBinding
import dev.hankli.sicbo.getConditionRes
import dev.hankli.sicbo.getDiceRes
import dev.hankli.sicbo.model.Round

class RoundAdapter : RecyclerView.Adapter<RoundAdapter.ViewHolder>() {

    var items: List<Round> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRoundBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(private val binding: ItemRoundBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Round) {
            binding.roundNumber.text = (absoluteAdapterPosition + 1).toString()
            binding.firstDice.setImageResource(getDiceRes(item.diceNumbers[0]))
            binding.secondDice.setImageResource(getDiceRes(item.diceNumbers[1]))
            binding.thridDice.setImageResource(getDiceRes(item.diceNumbers[2]))
            binding.sum.text = item.sum.toString()
            binding.condition.setText(getConditionRes(item.condition))
        }
    }
}
