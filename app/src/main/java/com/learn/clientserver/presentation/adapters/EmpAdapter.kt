package com.learn.clientserver.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.learn.clientserver.R
import com.learn.clientserver.domain.Success

class EmpAdapter(val itemSelectListener: ItemSelectListener) : RecyclerView.Adapter<EmpAdapter.ViewHolder>(){

    private val empList : MutableList<Success> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.content_main, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return empList.size
    }

    fun update(emp : List<Success>) {
        empList.clear()
        empList.addAll(emp)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(empList[position])
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(emp : Success) {
            val titleView = itemView.findViewById(R.id.titleView) as TextView
            titleView.text = emp.name

            itemView.setOnClickListener {
                itemSelectListener.onItemClick(adapterPosition)
            }
        }
    }

    //interface for recyclerview click
    interface ItemSelectListener {
        fun onItemClick(position: Int)
    }

    //function for geting the note at specific position
    fun getEmpAt(position: Int): Success {
        return empList.get(position)
    }
}