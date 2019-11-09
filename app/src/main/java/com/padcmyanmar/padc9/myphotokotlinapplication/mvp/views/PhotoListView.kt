package com.padcmyanmar.padc9.myphotokotlinapplication.mvp.views

import com.padcmyanmar.padc9.myphotokotlinapplication.data.vos.PhotoVO

interface PhotoListView: BaseView {

    fun displayPhotoList(photoList: List<PhotoVO>)
    fun displayError(errorMessage: String)
    fun navigateToDetail(photoId: String)
}