package com.padcmyanmar.padc9.myphotokotlinapplication.mvp.views

import com.padcmyanmar.padc9.myphotokotlinapplication.data.vos.PhotoVO

interface PhotoDetailView: BaseView {
    fun displayPhotoDetail(photoVO: PhotoVO)
    fun errorMessage(errorMessage: String)
}