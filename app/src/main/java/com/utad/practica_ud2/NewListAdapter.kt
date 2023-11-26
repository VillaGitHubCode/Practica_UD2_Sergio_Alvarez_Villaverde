package com.utad.practica_ud2

import android.content.Context
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.utad.practica_ud2.databinding.ItemListRvBinding

class NewListAdapter(private val context:Context,val actionClick: (new:New)->Unit): ListAdapter<New, NewListAdapter.NewListAdapterViewHolder> (NewItemCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewListAdapterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding : ItemListRvBinding = ItemListRvBinding.inflate(inflater, parent, false)
        return NewListAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewListAdapterViewHolder, position: Int) {
        val new: New = getItem(position)
        Glide.with(context)
            .load(new.image)
            .transform(MultiTransformation(RoundedCorners(20)))
            .into(holder.binding.ivImagenItemList)
        holder.binding.tvTituloItemList.text = new.title
        holder.binding.root.setOnClickListener { actionClick(new) }
    }


    inner class NewListAdapterViewHolder(val binding: ItemListRvBinding) : RecyclerView.ViewHolder(binding.root)


    object NewItemCallBack : DiffUtil.ItemCallback<New>(){
        override fun areItemsTheSame(oldItem: New, newItem: New): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: New, newItem: New): Boolean {
            return oldItem == newItem
        }

    }




}

