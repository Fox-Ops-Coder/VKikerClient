package com.example.vkiker.ui.leaderboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.core.content.ContextCompat
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
        var akvElo: TextView? = null
        var battlesCount: TextView? = null
        var winRate: TextView? = null
        var cups: TextView? = null
        var image: ImageView? = null

        init {
            number = itemView.findViewById(R.id.userNumber);
            name = itemView.findViewById(R.id.userNameShort);
            card = itemView.findViewById(R.id.shortUserCard);
            akvElo = itemView.findViewById(R.id.Elo);
            winRate = itemView.findViewById(R.id.WinRate);
            battlesCount = itemView.findViewById(R.id.BattlesCount);
            cups = itemView.findViewById(R.id.cups);
            image = itemView.findViewById(R.id.imageView);
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.short_user_layout, parent, false)
        return MyViewHolder(itemView);
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = shorUsers[position];
        holder.number?.text = user.Number;
        holder.name?.text = user.user.Name;
        holder.card?.setOnClickListener() {
            goToUserCall(user.user.ID);
        }
        holder.akvElo?.text = "AkvELOn:" + user.ELO.toInt().toString();
        holder.battlesCount?.text = "B: " + user.Battles.toString();
        holder.winRate?.text = "V: " + user.Wins.toString();
        val colorId = when (shorUsers[position].IntNumber) {
            1 -> R.color.purple_1000;
            2 -> R.color.golden;
            3 -> R.color.silver;
            4 -> R.color.bronze;
            else -> R.color.dark_blue;
        }
        val color = ContextCompat.getColor(holder.itemView.context, colorId);
        holder.card?.strokeColor = color;
        holder.number?.setTextColor(color);
    }

    override fun getItemCount(): Int {
        return shorUsers.size;
    }
}