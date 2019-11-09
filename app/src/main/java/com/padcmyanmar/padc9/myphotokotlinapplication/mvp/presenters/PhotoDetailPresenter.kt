package com.padcmyanmar.padc9.myphotokotlinapplication.mvp.presenters


import com.padcmyanmar.padc9.myphotokotlinapplication.activities.BaseActivity
import com.padcmyanmar.padc9.myphotokotlinapplication.data.models.PhotoListModelImpl
import com.padcmyanmar.padc9.myphotokotlinapplication.mvp.views.PhotoDetailView

class PhotoDetailPresenter: BasePresenter<PhotoDetailView>() {

    fun onUiReady(activity: BaseActivity, photoId: String) {
        if (photoId != null) {
            val model = PhotoListModelImpl
            model.getPhotoDetail(photoId, {
                mView.displayPhotoDetail(it)
            }, {
                mView.errorMessage(it)
            })
        }
    }
}