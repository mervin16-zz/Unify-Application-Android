package com.th3pl4gu3.unify.ui.leaves

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.th3pl4gu3.unify.core.Absence
import com.th3pl4gu3.unify.databinding.CustomCardLeavesBinding

class LeavesAdapter() : ListAdapter<Absence, LeavesAdapter.ViewHolder>(AbsenceLeavesDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: CustomCardLeavesBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(absence: Absence) {
            binding.absence = absence
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CustomCardLeavesBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class AbsenceLeavesDiffCallback: DiffUtil.ItemCallback<Absence>() {

    override fun areItemsTheSame(oldItem: Absence, newItem: Absence): Boolean {
        return oldItem.uniqueId == newItem.uniqueId
    }


    override fun areContentsTheSame(oldItem: Absence, newItem: Absence): Boolean {
        return oldItem == newItem
    }

}