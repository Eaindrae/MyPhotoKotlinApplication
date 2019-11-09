package com.padcmyanmar.padc9.myphotokotlinapplication.mvp.presenters

import androidx.lifecycle.ViewModel
import com.padcmyanmar.padc9.myphotokotlinapplication.data.models.PhotoListModelImpl
import com.padcmyanmar.padc9.myphotokotlinapplication.mvp.views.BaseView


abstract class BasePresenter<T: BaseView> : ViewModel() {

    protected lateinit var mView: T

    open fun initPresenter(view: T){
        this.mView  = view
    }
}