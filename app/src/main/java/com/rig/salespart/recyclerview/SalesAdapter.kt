package com.rig.salespart.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.rig.salespart.R

class SalesAdapter(var mapList:List<String>):RecyclerView.Adapter<SalesAdapter.MyViewHolder>() {

    inner class MyViewHolder(v: View):ViewHolder(v){
        var txt:TextView
        var img:ImageView
        init {
            txt=itemView.findViewById(R.id.mapText)
            img=itemView.findViewById(R.id.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(
            R.layout.map, parent, false
        )
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txt.text = mapList[position].toString()
        holder.img.setImageResource(R.drawable.location_icon)
    }

    override fun getItemCount(): Int {
        return mapList.size
    }

}