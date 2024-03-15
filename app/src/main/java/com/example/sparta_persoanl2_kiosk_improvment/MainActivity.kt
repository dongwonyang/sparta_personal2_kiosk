package com.example.sparta_persoanl2_kiosk_improvment

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById<ViewPager2>(R.id.viewpager_items)
        viewPager.adapter = MenuImageViewpagerAdapter(this)
        viewPager.isUserInputEnabled = true;


        var adapter = BasketRecyclerviewAdapter(BasketDataList.getData() ?: listOf())
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView_basket)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        BasketDataList.basketDataList.observe(this, Observer {
            adapter = BasketRecyclerviewAdapter(BasketDataList.getData() ?: listOf())
            recyclerView.adapter = adapter
            Log.d("observe", "success")
        })

        val buttonBasketPayment = findViewById<Button>(R.id.button_payment)
        val buttonBasketClear = findViewById<Button>(R.id.button_clear)

        buttonBasketPayment.setOnClickListener {
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.popup_payment)
            dialog.findViewById<TextView>(R.id.textview_bill).text = getBasketBill()
            dialog.show()
        }

        buttonBasketClear.setOnClickListener {
            BasketDataList.clearData()
        }
    }

    fun getBasketBill(): String{
        val answer = StringBuffer()
        var tempPrice = 0
        var totalPrice = 0
        for(i in BasketDataList.getData() ?: listOf()){
            tempPrice = i.price*i.num
            totalPrice += tempPrice
            answer.append("${i.price} * ${i.num} = $tempPrice\n")
        }
        answer.append("\nTotal Price: $totalPrice")
        return answer.toString()
    }
}

