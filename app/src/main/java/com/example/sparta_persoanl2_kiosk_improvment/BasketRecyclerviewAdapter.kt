package com.example.sparta_persoanl2_kiosk_improvment

import android.graphics.Rect
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class BasketRecyclerviewAdapter(private var itemList: List<BasketData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BasketRecyclerviewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_basket, parent, false)
        return BasketRecyclerviewAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = itemList[position]
        if (holder is BasketRecyclerviewAdapter.ViewHolder) holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textMenu = itemView.findViewById<TextView>(R.id.textview_menuName)
        val textNum = itemView.findViewById<TextView>(R.id.textview_numOfMenu)
        val buttonAdd = itemView.findViewById<Button>(R.id.button_basket_add)
        val buttonSub = itemView.findViewById<Button>(R.id.button_basket_sub)
        val constraintItem = itemView.findViewById<ConstraintLayout>(R.id.constraint_basket_item)

        fun bind(item: BasketData){
            textMenu.text = item.menuName
            textNum.text = item.num.toString()

            buttonAdd.setOnClickListener {
                item.num++
                textNum.text = item.num.toString()
            }
            buttonSub.setOnClickListener {
                item.num--
                textNum.text = item.num.toString()
                if(item.num==0){
                    BasketDataList.removeData(item)
                }
            }
        }

    }
}