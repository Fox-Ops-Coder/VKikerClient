package com.example.vkiker.ui.leaderboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vkiker.R
import com.foxdev.vkikermodule.objects.ShortUser
import com.google.android.material.card.MaterialCardView
import org.w3c.dom.Text

class LeaderboardRecyclerAdapter(private val shorUsers: List<ShortUser>) :
    RecyclerView.Adapter<LeaderboardRecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var number: TextView? = null
        var card: MaterialCardView? = null;
        var name: TextView? = null

        init {
            name = itemView.findViewById(R.id.userNameShort);
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.short_user_layout, parent, false)
        return MyViewHolder(itemView);
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name?.text = shorUsers[position].userId;
    }

    override fun getItemCount(): Int {
        return shorUsers.size;
    }
}