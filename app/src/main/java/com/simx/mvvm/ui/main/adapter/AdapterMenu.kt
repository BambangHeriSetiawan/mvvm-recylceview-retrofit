package com.simx.mvvm.ui.main.adapter


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.simx.mvvm.data.PintroMenuItem
import com.simx.mvvm.databinding.ItemMenuBinding
import com.simx.mvvm.ui.main.vm.PintroMenuViewModel

class AdapterMenu(var menus:List<PintroMenuItem>, var listener:AdapterMenu.onAdapterClicked): RecyclerView.Adapter<AdapterMenu.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, pos: Int): Holder {
        val itemMenuBinding = ItemMenuBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return Holder(itemMenuBinding)
    }

    override fun getItemCount(): Int {
        return menus.size
    }
    override fun onBindViewHolder(holder: Holder, pos: Int) {
        var pintroMenuItem = menus[pos]
        holder.bind(pintroMenuItem)
        holder.itemView.setOnClickListener { listener.onAdapterMenuClicked(pintroMenuItem) }
    }

    fun setMenu(pintroMenuItems:List< PintroMenuItem>){
        this.menus = pintroMenuItems
        notifyDataSetChanged()
    }

    /**
     *
     */
    class Holder(binding: ItemMenuBinding):RecyclerView.ViewHolder(binding.root) {
        private val itemMenuBinding: ItemMenuBinding = binding
        fun bind(pintroMenuItem: PintroMenuItem){
            with(itemMenuBinding){
              menu = PintroMenuViewModel(pintroMenuItem)
                executePendingBindings()
            }
        }
    }
    interface onAdapterClicked{
        fun onAdapterMenuClicked(pintroMenuItem: PintroMenuItem)
    }
}