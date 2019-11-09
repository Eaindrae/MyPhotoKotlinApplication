package com.padcmyanmar.padc9.myphotokotlinapplication.data.models

import android.content.Context
import com.padcmyanmar.padc9.myphotokotlinapplication.network.dataagents.PhotoDataAgent
import com.padcmyanmar.padc9.myphotokotlinapplication.network.dataagents.RetroFitDataAgent
import com.padcmyanmar.padc9.myphotokotlinapplication.persistence.PhotoDataBase


abstract class BaseModel {
    protected val dataAgent: PhotoDataAgent = RetroFitDataAgent

    protected lateinit var database: PhotoDataBase

    fun initDatabase(context: Context){
        database = PhotoDataBase.getInstance(context)
    }
}