package com.example.businesscard

import android.app.Application
import com.example.businesscard.data.appDataBase
import com.example.businesscard.data.BusinessCardRepositors

class app : Application()  {
    val dataBase by lazy { appDataBase.getDatabase(this) }
    val repository by lazy { BusinessCardRepositors(dataBase.busnessDao()) }
}