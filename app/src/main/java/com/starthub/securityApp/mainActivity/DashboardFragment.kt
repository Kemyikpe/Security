package com.starthub.securityApp.mainActivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.starthub.securityApp.R
import com.starthub.securityApp.adapter.RecentGuard
import com.starthub.securityApp.adapter.RecentGuardAdapter
import com.starthub.securityApp.databinding.FragmentDashboardBinding


class DashboardFragment : Fragment() {
    var binding: FragmentDashboardBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDashboardBinding.inflate(inflater,container,false)

        return binding!!.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var recentGuardList = mutableListOf(
            RecentGuard("peace_james","06,Apr,08:32 AM"),
            RecentGuard("peace_james","06,Apr,08:32 AM"),
            RecentGuard("peace_james","06,Apr,08:32 AM"),
            RecentGuard("peace_james","06,Apr,08:32 AM"),
        )

        val recentPostedAdapter = RecentGuardAdapter(recentGuardList)
        binding?.apply {
            recentGuardRv.adapter = recentPostedAdapter
            recentGuardRv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, true)

        }
    }
}

