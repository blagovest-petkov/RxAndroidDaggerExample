package com.example.rxandroiddaggerexample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rxandroiddaggerexample.R
import com.example.rxandroiddaggerexample.db.Repo
import kotlinx.android.synthetic.main.item_star.view.*

class GithubRepoAdapter(val context: Context) : RecyclerView.Adapter<GithubRepoAdapter.StarRepoViewHolder>() {
    //----------------------------------------------------------------------------------------------
    // Fields
    //----------------------------------------------------------------------------------------------
    private val data = ArrayList<Repo>()

    //----------------------------------------------------------------------------------------------
    // Instance creation
    //----------------------------------------------------------------------------------------------

    //----------------------------------------------------------------------------------------------
    // Lifecycle
    //----------------------------------------------------------------------------------------------
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarRepoViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_star, parent, false)

        return StarRepoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: StarRepoViewHolder, position: Int) {
        val repo: Repo = data[position]
        holder.repoName.text = repo.name
        holder.repoDesc.text = repo.description ?: context.getString(R.string.no_description)
        holder.repoLng.text = repo.language
        holder.repoStarsCount.text = repo.starCount.toString()
    }

    //----------------------------------------------------------------------------------------------
    // Public
    //----------------------------------------------------------------------------------------------
    fun addData(data: List<Repo>) {
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    //----------------------------------------------------------------------------------------------
    // Inner class
    //----------------------------------------------------------------------------------------------
    class StarRepoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val repoName: TextView = view.tvStarRepoName
        val repoDesc: TextView = view.tvStarRepoDesc
        val repoLng: TextView = view.tvStarRepoLng
        val repoStarsCount: TextView = view.tvStarRepoStarsCount
    }
}