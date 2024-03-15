package com.example.sparta_persoanl2_kiosk_improvment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object BasketDataList{
    private val _basketDataList = MutableLiveData<List<BasketData>>()
    val basketDataList: LiveData<List<BasketData>> = _basketDataList

    fun getData(): List<BasketData>? {
        return basketDataList.value
    }

    fun addData(item: BasketData) {
        val currentList = _basketDataList.value?.toMutableList() ?: mutableListOf()
        currentList.add(item)
        _basketDataList.value = currentList
    }

    fun removeData(item: BasketData){
        val currentList = _basketDataList.value?.toMutableList() ?: mutableListOf()
        currentList.remove(item)
        _basketDataList.value = currentList
    }

    fun clearData(){
        _basketDataList.value = null
    }
}