package com.example.businesscard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.businesscard.data.businessCard
import com.example.businesscard.data.BusinessCardRepositors
import java.lang.IllegalArgumentException

class MainViewModel(private val businessCardRepositors: BusinessCardRepositors ):ViewModel() {

    fun insert (businessCard: businessCard){
        businessCardRepositors.insert(businessCard)

    }
    fun getAll(): LiveData<List<businessCard>> {
        return businessCardRepositors.getAll()

    }
}
class MainViewModelFactory(private val repositors: BusinessCardRepositors):
    ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repositors) as T
        }
        throw IllegalArgumentException("unknown ViewModel class")

    }

}