package com.example.googlemapexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.googlemapexample.DTO.PointD
import com.example.googlemapexample.DTO.RestaurantInfoDTO
import com.example.googlemapexample.MainActivity

class RestaurantInfoViewModel : ViewModel(){
    // 수정은 외부에서 직접하지는 못하게, viewModel을 통해서 수정 가능
    private val restaurantMap = MutableLiveData<MutableMap<String, RestaurantInfoDTO>>()

    // 수정할 수 없는 값으로 변경해서
    fun getRestaurantList() : LiveData<MutableMap<String, RestaurantInfoDTO>> {
        return restaurantMap
    }

    private val curLocation = MutableLiveData<PointD>()

    fun getCurLocation()  : LiveData<PointD> {
        return curLocation
    }

    // 초기화
    init{
        // 여기서 값을 초기화 하면 map이 onready가 되지 않아 Null pointer exception
        restaurantMap.value = mutableMapOf<String, RestaurantInfoDTO>()
    }

    fun getRestaurantListFromServer(){
        // observer가 호출되려면 value라는 자체가 변해야 하므로 새로 만들어 대입
        val newList = mutableMapOf<String, RestaurantInfoDTO>()
        // AJAX 이용 RestaureantInfoList를 받아온 후 setting
        // test용으로 하나만 넣어서 새 list를 만듬
        newList.put("BusanIT", RestaurantInfoDTO("BusanIT", 35.22,  128.32))
        newList.put("BusanRest", RestaurantInfoDTO("BusanRest", 35.25, 128.35))
        restaurantMap.value = newList
    }

    fun setRestaurantList( newMap : MutableMap<String, RestaurantInfoDTO>){
        restaurantMap.value= newMap
    }

    fun setCurrentLocation( newLocation : PointD){
        curLocation.value = newLocation
    }
}