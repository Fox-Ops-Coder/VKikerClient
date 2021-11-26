package com.example.vkiker.ui.leaderboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vkiker.R
import com.foxdev.vkikermodule.net.netobjects.LeaderInfo

import com.google.android.material.card.MaterialCardView
import org.w3c.dom.Text

class LeaderboardRecyclerAdapter(
    private val shorUsers: List<LeaderInfo>,
    private val goToUserCall: (String?) -> Unit
) :
    RecyclerView.Adapter<LeaderboardRecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var number: TextView? = null
        var card: MaterialCardView? = null;
        var name: TextView? = null

        init {
            name = itemView.findViewById(R.id.userNameShort);
            card = itemView.findViewById(R.id.shortUserCard);
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.short_user_layout, parent, false)
        return MyViewHolder(itemView);
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val userId = shorUsers[position].user.ID
        holder.name?.text = userId;
        holder.card?.setOnClickListener() {
            goToUserCall(userId);
        }
    }

    override fun getItemCount(): Int {
        return shorUsers.size;
    }
}