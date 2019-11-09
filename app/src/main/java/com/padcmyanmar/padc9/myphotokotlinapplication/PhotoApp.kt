package com.padcmyanmar.padc9.myphotokotlinapplication

import android.app.Application
import com.padcmyanmar.padc9.myphotokotlinapplication.data.models.PhotoListModelImpl

class PhotoApp: Application(){

    override fun onCreate() {
        super.onCreate()
        PhotoListModelImpl.initDatabase(applicationContext)
    }
}