package io.github.rosariopfernandes.personalbanking.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.github.rosariopfernandes.personalbanking.R
import io.github.rosariopfernandes.personalbanking.model.Source

class SourcesAdapter(val sourcesList:List<Source>?):
        RecyclerView.Adapter<SourcesAdapter.SourcesViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourcesViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent,
                false)
        return SourcesViewHolder(v)
    }

    override fun getItemCount(): Int {
        return sourcesList?.size ?: 0
    }

    override fun onBindViewHolder(holder: SourcesViewHolder, position: Int) {
        val source = sourcesList!![position]
        holder.txtSourceName!!.text = source.name
    }

    inner class SourcesViewHolder(v:View):RecyclerView.ViewHolder(v)
    {
        var txtSourceName:TextView? = null

        init {
            txtSourceName = v.findViewById(R.id.txtCategoryName)
        }
    }
}