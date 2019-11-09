package com.padcmyanmar.padc9.myphotokotlinapplication.mvp.presenters

import androidx.lifecycle.Observer
import com.padcmyanmar.padc9.myphotokotlinapplication.activities.BaseActivity
import com.padcmyanmar.padc9.myphotokotlinapplication.data.models.PhotoListModelImpl
import com.padcmyanmar.padc9.myphotokotlinapplication.delegates.ItemClicked
import com.padcmyanmar.padc9.myphotokotlinapplication.mvp.views.PhotoListView

class PhotoListPresenter: BasePresenter<PhotoListView>(), ItemClicked {

    override fun onItemClicked(id: String) {
        mView.navigateToDetail(id)
    }

    fun onUiReady(activity: BaseActivity){
        val model = PhotoListModelImpl
        model.getAllPhotos { mView.displayError(it) }
            .observe(activity, Observer {
                mView.displayPhotoList(it)
            })
    }
}