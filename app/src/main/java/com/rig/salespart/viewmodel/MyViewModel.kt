package com.rig.salespart.viewmodel

import androidx.lifecycle.ViewModel
import com.rig.salespart.repository.SalesRepository

class MyViewModel(private val salesRepository: SalesRepository):ViewModel() {

    fun insertMap(name:String):Unit{
        salesRepository.insertMap(name)
    }
}