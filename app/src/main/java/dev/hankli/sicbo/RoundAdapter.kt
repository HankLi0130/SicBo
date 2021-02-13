package dev.hankli.sicbo

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.hankli.sicbo.model.Round
import tw.hankli.brookray.core.extension.viewOf

class RoundAdapter : RecyclerView.Adapter<RoundAdapter.ViewHolder>() {

    var items: List<Round> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.viewOf(R.layout.item_round)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Round) {

        }
    }
}
