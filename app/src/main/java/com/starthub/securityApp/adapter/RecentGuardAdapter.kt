package com.starthub.securityApp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.starthub.securityApp.R
import com.starthub.securityApp.databinding.RecentGuardItemBinding


class RecentGuardAdapter (
        var recentGuard:List<RecentGuard>
    ): RecyclerView.Adapter<RecentGuardAdapter.RecentGuardViewHolder>() {


        inner class RecentGuardViewHolder(val binding: RecentGuardItemBinding) : RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentGuardViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = RecentGuardItemBinding.inflate(layoutInflater, parent, false)
            return RecentGuardViewHolder(binding)
        }

        override fun getItemCount(): Int {
            return recentGuard.size
        }

        override fun onBindViewHolder(holder: RecentGuardViewHolder, position: Int) {
            holder.binding.apply {
                companyNameTv.text = recentGuard[position].companyName
                durationTv.text = recentGuard[position].duration
                // tvTitle this now works

                val isVisible: Boolean = recentGuard[position].visible
//                content.visibility = if(isVisible) View.VISIBLE else View.GONE

                dropdown.setOnClickListener {
                    if(recentGuard[position].visible){
                        recentGuard[position].visible=false;
                        dropdown.setImageResource(R.drawable.arrow)
                    }else{
                        recentGuard[position].visible=true;
                        dropdown.setImageResource(R.drawable.arrow_up)
                    }
                    notifyItemChanged(position)
                }
            }
        }


    }
