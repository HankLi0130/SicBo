package app.hankdev.sicbo.round

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import app.hankdev.sicbo.databinding.ItemRoundBinding
import app.hankdev.sicbo.getConditionColorRes
import app.hankdev.sicbo.getConditionStringRes
import app.hankdev.sicbo.getDiceRes
import app.hankdev.sicbo.model.Round

class RoundAdapter : RecyclerView.Adapter<RoundAdapter.ViewHolder>() {

    var items: List<Round> = emptyList()
    lateinit var removeItemListener: (item: Round) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRoundBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], removeItemListener)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(private val binding: ItemRoundBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Round, removeItemListener: (item: Round) -> Unit) {
            binding.roundNumber.text = (absoluteAdapterPosition + 1).toString()
            binding.firstDice.setImageResource(getDiceRes(item.diceNumbers[0]))
            binding.secondDice.setImageResource(getDiceRes(item.diceNumbers[1]))
            binding.thridDice.setImageResource(getDiceRes(item.diceNumbers[2]))
            binding.sum.text = String.format("%2d", item.sum)
            binding.condition.apply {
                setText(getConditionStringRes(item.condition))
                setTextColor(ContextCompat.getColor(context, getConditionColorRes(item.condition)))
            }

            binding.roundNumber.setOnClickListener { removeItemListener(item) }
        }
    }
}
