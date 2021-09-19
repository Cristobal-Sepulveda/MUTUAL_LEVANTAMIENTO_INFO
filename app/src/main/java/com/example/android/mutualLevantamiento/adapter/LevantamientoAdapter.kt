package com.example.android.mutualLevantamiento.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.mutualLevantamiento.data.domainObject.LEVANTAMIENTO
import com.example.android.mutualLevantamiento.databinding.TextItemViewBinding


class LevantamientoAdapter(private val onClickListener: OnClickListener)
    : ListAdapter<LEVANTAMIENTO, LevantamientoAdapter.LevantamientoViewHolder>(DiffCallBack){

    class LevantamientoViewHolder(private var binding: TextItemViewBinding):
            RecyclerView.ViewHolder(binding.root) {
        fun bind(levantamiento: LEVANTAMIENTO){
            binding.levantamientoItem = levantamiento
            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements
            binding.executePendingBindings()
        }
    }

    companion object DiffCallBack: DiffUtil.ItemCallback<LEVANTAMIENTO>(){
        override fun areItemsTheSame(oldItem: LEVANTAMIENTO, newItem: LEVANTAMIENTO): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: LEVANTAMIENTO, newItem: LEVANTAMIENTO): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onBindViewHolder(holder: LevantamientoViewHolder, position: Int) {
        val levantamiento = getItem(position)
        holder.itemView.setOnClickListener(){
            onClickListener.onClick(levantamiento)
        }
        holder.bind(levantamiento)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LevantamientoViewHolder {
        return LevantamientoViewHolder(TextItemViewBinding.inflate(LayoutInflater.from(parent.context)))
    }
    class OnClickListener(val clickListener: (levantamiento: LEVANTAMIENTO) -> Unit) {
        fun onClick(levantamiento: LEVANTAMIENTO) = clickListener(levantamiento)
    }
}
