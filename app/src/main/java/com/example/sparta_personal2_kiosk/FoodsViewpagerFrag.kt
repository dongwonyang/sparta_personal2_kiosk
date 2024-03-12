package com.example.sparta_personal2_kiosk

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.DEFAULT_ARGS_KEY
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FoodsViewpagerFrag : Fragment(){
    private lateinit var foodsData : List<FoodsData>
    private var foodType = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{
            foodType = it.getInt(ARG_FOOD_TYPE)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val foodTypes = listOf<Foods>(
            Burgers(),
            Chicken(),
            Drinks(),
            FrozenCustard()
        )

        foodsData = createFoodsData(foodTypes[foodType])
        Log.d("foodsData", foodsData.toString())

        val view = inflater.inflate(R.layout.frag_foods_images, container, false)
        val adapter = FoodsRecyclerViewAdapter(foodsData)
        val recyclerView: RecyclerView? = view.findViewById(R.id.recyclerView)
        recyclerView?.layoutManager = LinearLayoutManager(view.context)
        recyclerView?.adapter = adapter


        return view
    }

    fun createFoodsData(foodType : Foods): List<FoodsData>{
        val answer = mutableListOf<FoodsData>()
        var tempName = mutableListOf<String>()
        var tempPrice = mutableListOf<String>()
        for((index, i) in foodType.menuList.withIndex()){
            tempName.add(i)
            tempPrice.add(when(foodType.type){
                "Burgers" ->  Burgers.burgersPrice.get(i).toString()
                "FrozenCustard" -> FrozenCustard.frozenCustardPrice.get(i).toString()
                "Chicken" -> Chicken.chickenPrice.get(i).toString()
                "Drinks" -> Drinks.drinksPrice.get(i).toString()
                else -> ""
            })

            if((index+1)%3==0 || index == foodType.menuList.size-1) {
                answer.add(FoodsData(tempName.toList(), tempPrice.toList()))
                tempName.clear()
                tempPrice.clear()
            }
        }

        return answer.toList()
    }


    companion object{
        private const val ARG_FOOD_TYPE = "pageType"

        fun newInstance(position: Int): Fragment{
            val frag = FoodsViewpagerFrag()
            val args = Bundle()

            args.putInt(ARG_FOOD_TYPE, position)
            frag.arguments = args
            return frag
        }
    }

}