package com.example.recyclerviewwithdraganddropswipe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewwithdraganddropswipe.databinding.TabItemBinding

class TabListAdapter : RecyclerView.Adapter<TabListAdapter.TabViewHolder>(), ItemTouchHelperListener{

    private var items = arrayListOf<TabItem>()

    fun setItems(_items: ArrayList<TabItem>) {
        items = _items
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TabViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TabItemBinding.inflate(inflater, parent, false)
        return TabViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TabViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun onItemMove(from_position: Int, to_position: Int): Boolean {
        val item: TabItem = items[from_position]
        items.removeAt(from_position)
        items.add(to_position, item)
        item.number = to_position
        notifyItemMoved(from_position, to_position) // 아이템 삭제됐음을 알림
        return true
    }

    override fun onItemSwipe(position: Int) {
        items.removeAt(position)
        notifyDataSetChanged()
    }

    class TabViewHolder(private val binding: TabItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TabItem) {
            binding.tvName.text = item.name
            item.number = adapterPosition
        }

    }

}
