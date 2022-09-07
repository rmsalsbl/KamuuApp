package com.slowmotion.kamuuapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.slowmotion.kamuuapp.model.ResponseMain
import kotlinx.android.synthetic.main.activity_detail.view.*
import kotlinx.android.synthetic.main.item_row_kamu.view.*


class AdapterMain (
    val data : List<ResponseMain?>,
    val itemClick: OnClickListener
) : RecyclerView.Adapter<AdapterMain.ViewHolder>() {

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: ResponseMain){
            view.tv_detail_name.text = item.Name

            Glide.with(view.context)
                .load(item.Picture)
                .apply(RequestOptions())
                .override(500,500)
                .placeholder(R.drawable.ic_launcher_background)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)
                .into(view.iv_photo)

            view.setOnClickListener{
                itemClick.detail(item)
            }
        }
    }

    interface OnClickListener {
        fun detail(item: ResponseMain)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterMain.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_kamu, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterMain.ViewHolder, position: Int) {
        val item = data?.get(position)

        holder.bind(item!!)
    }

    override fun getItemCount(): Int = data?.size
}