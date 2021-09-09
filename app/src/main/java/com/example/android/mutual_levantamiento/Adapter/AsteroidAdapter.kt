package com.example.android.mutual_levantamiento.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.mutual_levantamiento.data.DBO.LEVANTAMIENTO_DBO
import com.example.android.mutual_levantamiento.databinding.TextItemViewBinding


class LevantamientoAdapter(private val onClickListener: OnClickListener)
    : ListAdapter<LEVANTAMIENTO_DBO, LevantamientoAdapter.LevantamientoViewHolder>(DiffCallBack){

    class LevantamientoViewHolder(private var binding: TextItemViewBinding):
            RecyclerView.ViewHolder(binding.root) {
        fun bind(levantamiento: LEVANTAMIENTO_DBO){
            binding.levantamientoItem = levantamiento
            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements
            binding.executePendingBindings()
        }
    }

    companion object DiffCallBack: DiffUtil.ItemCallback<LEVANTAMIENTO_DBO>(){
        override fun areItemsTheSame(oldItem: LEVANTAMIENTO_DBO, newItem: LEVANTAMIENTO_DBO): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: LEVANTAMIENTO_DBO, newItem: LEVANTAMIENTO_DBO): Boolean {
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
    class OnClickListener(val clickListener: (levantamiento: LEVANTAMIENTO_DBO) -> Unit) {
        fun onClick(levantamiento: LEVANTAMIENTO_DBO) = clickListener(levantamiento)
    }
}
