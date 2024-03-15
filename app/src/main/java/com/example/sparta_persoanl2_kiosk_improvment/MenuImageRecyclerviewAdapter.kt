package com.example.sparta_persoanl2_kiosk_improvment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class MenuImageRecyclerviewAdapter(private val itemList: List<MenuImageData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_foods, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = itemList[position]
//        Log.d("recycler item", item.toString())
        if (holder is ViewHolder) holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }




    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img1 = itemView.findViewById<ImageView>(R.id.image_item_food1)
        val img2 = itemView.findViewById<ImageView>(R.id.image_item_food2)
        val img3 = itemView.findViewById<ImageView>(R.id.image_item_food3)

        val text1 = itemView.findViewById<TextView>(R.id.text_item_foodname1)
        val text2 = itemView.findViewById<TextView>(R.id.text_item_foodname2)
        val text3 = itemView.findViewById<TextView>(R.id.text_item_foodname3)

        fun bind(item: MenuImageData) {
            val imgList = listOf(img1, img2, img3)
            val textList = listOf(text1, text2, text3)

            imgList.forEach{it.visibility = View.INVISIBLE}
            textList.forEach{it.text = ""}


            getFileResources(item.menuNameList).forEachIndexed{index, resource ->
                imgList[index].setImageResource(resource)
                imgList[index].visibility = View.VISIBLE
                textList[index].text = "${item.menuNameList[index]}\n" +
                        "W ${item.menuPriceList[index]}"
            }

            img1.setOnClickListener {
                BasketDataList.addData(BasketData(item.menuNameList[0], (item.menuPriceList[0].toDouble()*1000).toInt() ,1))
            }
            img2.setOnClickListener {
                BasketDataList.addData(BasketData(item.menuNameList[1], (item.menuPriceList[1].toDouble()*1000).toInt(),1))
            }
            img3.setOnClickListener {
                BasketDataList.addData(BasketData(item.menuNameList[2], (item.menuPriceList[2].toDouble()*1000).toInt(),1))
            }
        }

        fun toFileName(s: String): String {
            if(s=="Float") return "float0"
            return s.filter { it.isLetter() || it.isDigit() || it.isWhitespace() }
                .map { it.lowercase() }.joinToString("").replace("\\s+".toRegex(), " ")
                .replace(" ", "_")
        }

        fun getFileResources(filenames: List<String>): List<Int> {
            val context = img1.context
            val resources = mutableListOf<Int>()
            filenames.forEach {
                resources.add(
                    context.resources.getIdentifier(
                        toFileName(it), "drawable", context.packageName
                    )
                )
            }
            return resources.toList()
        }
    }
}