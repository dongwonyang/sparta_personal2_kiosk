package com.example.sparta_persoanl2_kiosk_improvment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MenuImageViewpagerFragment: Fragment() {
    private var menuType: Int = 0
    val menuTypeList = listOf<Menu>(
        Burger(),
        Chicken(),
        Drink(),
        FrozenCustard()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{
            menuType = it.getInt(ARG_TYPE)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.frag_foods_images, container, false)

        val adapter = MenuImageRecyclerviewAdapter(getMenuImageData())
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = adapter

        return view
    }

    fun  getMenuImageData(): List<MenuImageData>{
        var menuNameList : List<String> = listOf("")
        var menuPriceList = mutableListOf<String>()
        when(menuType){
            0 -> {
                menuNameList = MenuDetailInfo.burgersList
                menuNameList.forEach{
                    menuPriceList.add(MenuDetailInfo.burgersPrice.get(it)?.toString() ?: "0.0")
                }
            }
            1 -> {
                menuNameList = MenuDetailInfo.chickenList
                menuNameList.forEach{
                    menuPriceList.add(MenuDetailInfo.chickenPrice.get(it)?.toString() ?: "0.0")
                }
            }
            2 -> {
                menuNameList = MenuDetailInfo.drinksList
                menuNameList.forEach{
                    menuPriceList.add(MenuDetailInfo.drinksPrice.get(it)?.toString() ?: "0.0")
                }
            }
            3 -> {
                menuNameList = MenuDetailInfo.frozenCustardList
                menuNameList.forEach{
                    menuPriceList.add(MenuDetailInfo.frozenCustardPrice.get(it)?.toString() ?: "0.0")
                }
            }
        }

        val menuImageData = mutableListOf<MenuImageData>()
        var tempNum :Int = 3

        while(tempNum < menuNameList.size){
            val menuNameData = menuNameList.slice(tempNum-3 until tempNum)
            val menuPriceData = menuPriceList.slice(tempNum-3 until tempNum)
            menuImageData.add(MenuImageData(menuNameData, menuPriceData))
            tempNum += 3
        }
        val menuNameData = menuNameList.slice(tempNum-3 until menuNameList.size)
        val menuPriceData = menuPriceList.slice(tempNum-3 until menuNameList.size)
        menuImageData.add(MenuImageData(menuNameData, menuPriceData))

        Log.d("menuImageData", menuImageData.toList().toString())
        return menuImageData.toList()
    }


    companion object{
        const val ARG_TYPE = "ARG MENU TYPE"

        fun newInstance(position: Int): Fragment{
            val frag = MenuImageViewpagerFragment()
            val args = Bundle()

            args.putInt(ARG_TYPE, position)
            frag.arguments = args
            return frag
        }

    }
}