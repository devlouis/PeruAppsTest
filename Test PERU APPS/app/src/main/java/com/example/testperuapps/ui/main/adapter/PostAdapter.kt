package com.example.testperuapps.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.example.entity.Post
import com.example.testperuapps.R
import kotlinx.android.synthetic.main.item_post_layout.view.*

/**
 * Created by Luis Lopez on 2019-10-26.
 * Solera Mobile
 * Peru, Lima.
 */
class PostAdapter(var onDetail: ((Post) -> Unit)? = null): RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    var listData: MutableList<Post> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        lateinit var binding: ViewDataBinding
        val inflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(inflater, R.layout.item_post_layout, parent, false)
        return  ViewHolder(binding = binding)
    }

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(listData[position],onDetail!!)

    class ViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Post, onDetail: (Post) -> Unit) {
            this.binding.setVariable(BR.item, item)
            this.binding.executePendingBindings()
            this.binding.root.cviPost.setOnClickListener {
                onDetail.invoke(item)
            }
        }
    }
}