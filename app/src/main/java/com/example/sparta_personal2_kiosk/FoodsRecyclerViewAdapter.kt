package com.example.sparta_personal2_kiosk

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodsRecyclerViewAdapter(private val itemList: List<FoodsData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_foods, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = itemList[position]
        Log.d("recycler item", item.toString())
        if (holder is ViewHolder) holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image1 = itemView.findViewById<ImageView>(R.id.image_item_food1)
        val image2 = itemView.findViewById<ImageView>(R.id.image_item_food2)
        val image3 = itemView.findViewById<ImageView>(R.id.image_item_food3)

        val text1 = itemView.findViewById<TextView>(R.id.text_item_foodname1)
        val text2 = itemView.findViewById<TextView>(R.id.text_item_foodname2)
        val text3 = itemView.findViewById<TextView>(R.id.text_item_foodname3)

        fun bind(item: FoodsData) {
            val context = image1.context
            Log.d("bind toFileName","${toFileName(item.foodName[0])}")
            if (item.foodName.size == 3) {
                val resourceId1 = context.resources.getIdentifier(
                    toFileName(item.foodName[0]).toLowerCase(),
                    "drawable",
                    context.packageName
                )
                val resourceId2 = context.resources.getIdentifier(
                    toFileName(item.foodName[1]).toLowerCase(),
                    "drawable",
                    context.packageName
                )
                val resourceId3 = context.resources.getIdentifier(
                    toFileName(item.foodName[2]).toLowerCase(),
                    "drawable",
                    context.packageName
                )

                image1.setImageResource(resourceId1)
                image2.setImageResource(resourceId2)
                image3.setImageResource(resourceId3)

                text1.text = "${item.foodName[0]}\nW ${item.foodPrice[0]}"
                text2.text = "${item.foodName[1]}\nW ${item.foodPrice[1]}"
                text3.text = "${item.foodName[2]}\nW ${item.foodPrice[2]}"
            } else {
                val resourceId1 = context.resources.getIdentifier(
                    toFileName(item.foodName[0]).toLowerCase(),
                    "drawable",
                    context.packageName
                )
                image1.setImageResource(resourceId1)
                text1.text = "${item.foodName[0]}\nW ${item.foodPrice[0]}"

                image2.visibility = View.INVISIBLE
                image3.visibility = View.INVISIBLE
                text2.visibility = View.INVISIBLE
                text3.visibility = View.INVISIBLE

                if (item.foodName.size > 1) {
                    val resourceId2 = context.resources.getIdentifier(
                        toFileName(item.foodName[1]).toLowerCase(),
                        "drawable",
                        context.packageName
                    )
                    image2.setImageResource(resourceId1)
                    text2.text = "${item.foodName[1]}\nW ${item.foodPrice[1]}"

                    image2.visibility = View.VISIBLE
                    text2.visibility = View.VISIBLE
                }

            }
        }

        fun toFileName(s: String): String {
            if (s == "Float") return "float0"
            return s.filter { it.isDigit() || it.isLetter() || it.isWhitespace()}.map { it.lowercase() }.joinToString("").replace("\\s+".toRegex(), " ").replace(" ", "_")
        }
    }
}