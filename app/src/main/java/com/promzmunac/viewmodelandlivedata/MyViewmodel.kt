package com.promzmunac.viewmodelandlivedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewmodel: ViewModel() {
    private val _message =  MutableLiveData<String>()
    private val _data =  MutableLiveData<Int>()
    private val _load =  MutableLiveData<Int>()

    val message: LiveData<String> = _message

    val data: LiveData<Int> = _data

    val load: LiveData<Int> = _load

    init {
        //initialise with a call from our main helper class
        _message.value = HelperClass.getMessage()
        _data.value = HelperClass.getData()

        /*

        _message.value = "you have added more data. new balance is"
        _data.value = 0

        */
    }

    fun loadData(button: Int) {
        _load.value = when (button) {
            1 -> 100
            2 -> 200
            else -> 0
        }
        _data.value = _data.value!! + _load.value!!
    }

}