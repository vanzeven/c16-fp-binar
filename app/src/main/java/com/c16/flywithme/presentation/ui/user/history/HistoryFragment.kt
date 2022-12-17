package com.c16.flywithme.presentation.ui.user.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.c16.flywithme.R

class HistoryFragment : Fragment() {

    private lateinit var notificationBadges: View
    private var count: Int = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

//    private fun updateBadgeCount(count: Int = 0) {
//        val itemView = navigation.getChildAt(1) as ? BottomNavigationItemView
//    }
}