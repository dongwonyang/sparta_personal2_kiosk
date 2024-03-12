package com.example.sparta_personal2_kiosk

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager : ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager= findViewById<ViewPager2>(R.id.viewpager_items)
        viewPager.adapter = FoodsViewPagerAdapter(this)
        viewPager.isUserInputEnabled = true;

        val foodType1 = findViewById<TextView>(R.id.textView1)
        val foodType2 = findViewById<TextView>(R.id.textView2)
        val foodType3 = findViewById<TextView>(R.id.textView3)
        val foodType4 = findViewById<TextView>(R.id.textView4)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                foodType1.setBackgroundColor(Color.parseColor("#FFFFFF"))
                foodType2.setBackgroundColor(Color.parseColor("#FFFFFF"))
                foodType3.setBackgroundColor(Color.parseColor("#FFFFFF"))
                foodType4.setBackgroundColor(Color.parseColor("#FFFFFF"))

                when(position){
                    0 -> foodType1.setBackgroundColor(Color.parseColor("#FFC9C9"))
                    1 -> foodType2.setBackgroundColor(Color.parseColor("#FFC9C9"))
                    2 -> foodType3.setBackgroundColor(Color.parseColor("#FFC9C9"))
                    3 -> foodType4.setBackgroundColor(Color.parseColor("#FFC9C9"))
                }
            }
        })

        val textType1 = findViewById<TextView>(R.id.textView1)
        val textType2 = findViewById<TextView>(R.id.textView2)
        val textType3 = findViewById<TextView>(R.id.textView3)
        val textType4 = findViewById<TextView>(R.id.textView4)

        moveToButton(textType1, 0)
        moveToButton(textType2, 1)
        moveToButton(textType3, 2)
        moveToButton(textType4, 3)

        val basketData = mutableListOf<BasketData>()

        basketData.add(BasketData("food", 7000, 1))
        var foodName = intent.getStringExtra("selectFood").toString()
        basketData.add(BasketData(foodName, 1, 1))

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView_basket)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = BasketRecyclerviewAdapter(basketData.toList())


    }


    fun moveToButton(moveToPageButton: TextView, page: Int){
        moveToPageButton.setOnClickListener {
            viewPager.currentItem = page
        }
    }
}