package com.example.rxandroiddaggerexample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rxandroiddaggerexample.R
import com.example.rxandroiddaggerexample.model.Repo
import kotlinx.android.synthetic.main.item_star.view.*

class GithubRepoAdapter : RecyclerView.Adapter<GithubRepoAdapter.StarRepoViewHolder>() {
    //----------------------------------------------------------------------------------------------
    // Fields
    //----------------------------------------------------------------------------------------------
    val data = ArrayList<Repo>()

    //----------------------------------------------------------------------------------------------
    // Lifecycle
    //----------------------------------------------------------------------------------------------
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarRepoViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_star, parent)

        return StarRepoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: StarRepoViewHolder, position: Int) {
        val repo = data[position]
        holder.repoName.text = repo.name
        holder.repoDesc.text = repo.desc
        holder.repoLng.text = repo.lng
    }

    //----------------------------------------------------------------------------------------------
    // Public
    //----------------------------------------------------------------------------------------------
    fun addData(data: ArrayList<Repo>) {
        data.addAll(data)
        notifyDataSetChanged()
    }

    //----------------------------------------------------------------------------------------------
    // Inner class
    //----------------------------------------------------------------------------------------------
    class StarRepoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val repoName = view.tvStarRepoName
        val repoDesc = view.tvStarRepoDesc
        val repoLng = view.tvStarRepoLng
        val repoStarsCount = view.tvStarRepoStarsCount
    }
}