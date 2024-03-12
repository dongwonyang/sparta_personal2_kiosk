package com.example.sparta_personal2_kiosk

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class BasketRecyclerviewAdapter (private val itemList: List<BasketData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_basket, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = itemList[position]
        if (holder is ViewHolder) holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foodName = itemView.findViewById<TextView>(R.id.textview_menuName)
        val foodNum = itemView.findViewById<TextView>(R.id.textview_numOfMenu)
        val buttonAdd = itemView.findViewById<Button>(R.id.button_basket_add)
        val buttonSub = itemView.findViewById<Button>(R.id.button_basket_sub)

        fun bind(item: BasketData) {
            foodName.text = item.foodName
            foodNum.text = item.numOfFood.toString()

            buttonAdd.setOnClickListener {
                item.numOfFood++
                foodNum.text = item.numOfFood.toString()
            }

            buttonSub.setOnClickListener {
                item.numOfFood--
                foodNum.text = item.numOfFood.toString()
                if(item.numOfFood == 0) itemView.findViewById<ConstraintLayout>(R.id.constraint_basket_item).visibility = View.GONE
            }
        }
    }
}