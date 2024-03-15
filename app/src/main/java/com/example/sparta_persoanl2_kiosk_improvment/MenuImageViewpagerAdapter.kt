package com.example.sparta_persoanl2_kiosk_improvment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MenuImageViewpagerAdapter (fm: FragmentActivity) : FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return MenuImageViewpagerFragment.newInstance(position)
    }
}