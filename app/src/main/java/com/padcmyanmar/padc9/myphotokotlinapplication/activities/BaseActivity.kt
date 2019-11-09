package com.padcmyanmar.padc9.myphotokotlinapplication.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.padcmyanmar.padc9.myphotokotlinapplication.data.models.PhotoListModel
import com.padcmyanmar.padc9.myphotokotlinapplication.data.models.PhotoListModelImpl

abstract class BaseActivity:AppCompatActivity() {

    protected lateinit var model: PhotoListModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = PhotoListModelImpl
    }
}