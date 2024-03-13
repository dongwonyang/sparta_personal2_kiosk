package com.example.sparta_personal2_kiosk

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import android.app.Dialog
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager : ViewPager2
    lateinit var adapter : BasketRecyclerviewAdapter
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


        val recyclerView: RecyclerView = findViewById(R.id.recyclerView_basket)
        adapter = BasketRecyclerviewAdapter(BasketItems.basketDataList.toList())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter



        val paymentButton = findViewById<Button>(R.id.button_payment)
        val clearButton = findViewById<Button>(R.id.button_clear)

        paymentButton.setOnClickListener {
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.popup_payment)
            val textviewBill = dialog.findViewById<TextView>(R.id.textview_bill)
            textviewBill.text = BasketItems.totalPrice()
            val buttonCash = dialog.findViewById<Button>(R.id.button_cash)
            buttonCash.setOnClickListener {

                dialog.dismiss()
            }
            val buttonCard = dialog.findViewById<Button>(R.id.button_card)
            buttonCard.setOnClickListener {

                dialog.dismiss()
            }

            dialog.show()
        }
        clearButton.setOnClickListener {
            BasketItems.basketDataList.clear()
            BasketItems.basketUpdateChannel.trySend(Unit)
        }


        CoroutineScope(Dispatchers.Main).launch {
//            while (true) {
//                if (BasketItems.controlBool) {
//                    adapter = BasketRecyclerviewAdapter(BasketItems.basketDataList.toList())
//                    recyclerView.adapter = adapter
//                    BasketItems.controlBool = false
//                }
//                delay(1000)
//            }
            for (event in BasketItems.basketUpdateChannel) {
                // 이벤트가 발생할 때만 실행되는 부분
                adapter = BasketRecyclerviewAdapter(BasketItems.basketDataList.toList())
                recyclerView.adapter = adapter
            }
        }
    }


    fun moveToButton(moveToPageButton: TextView, page: Int){
        moveToPageButton.setOnClickListener {
            viewPager.currentItem = page
        }
    }
}


class BasketItems {
    companion object {
        val basketDataList = mutableListOf<BasketData>()
        val basketUpdateChannel = Channel<Unit>()
        var controlBool = false

        fun totalPrice() : String{
            var answer = ""
            var totalPrice = 0
            var tempPrice = 0
            for (basketData in basketDataList) {
                tempPrice = basketData.foodPrice * basketData.numOfFood
                answer += "${basketData.foodPrice}x${basketData.numOfFood}=${tempPrice}\n"
                totalPrice += tempPrice
            }
            answer += "TotalPrice = $totalPrice"
            return answer
        }
    }
}