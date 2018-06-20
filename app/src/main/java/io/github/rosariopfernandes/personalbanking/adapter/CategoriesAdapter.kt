package io.github.rosariopfernandes.personalbanking.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.github.rosariopfernandes.personalbanking.R
import io.github.rosariopfernandes.personalbanking.model.Category

class CategoriesAdapter(val categoriesList:List<Category>?):RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent,
                false)
        return CategoriesViewHolder(v)
    }

    override fun getItemCount(): Int {
        return categoriesList?.size ?: 0
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val category = categoriesList!![position]
        holder.txtCategoryName!!.text = category.name
    }

    inner class CategoriesViewHolder(v:View):RecyclerView.ViewHolder(v)
    {
        var txtCategoryName:TextView? = null

        init {
            txtCategoryName = v.findViewById(R.id.txtCategoryName)
        }
    }
}