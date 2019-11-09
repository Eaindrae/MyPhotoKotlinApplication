package com.padcmyanmar.padc9.myphotokotlinapplication.data.models

import androidx.lifecycle.LiveData
import com.padcmyanmar.padc9.myphotokotlinapplication.data.vos.PhotoVO

interface PhotoListModel {
    fun getAllPhotos(
        onFailure: (String) -> Unit
    ) : LiveData<List<PhotoVO>>

    fun getPhotoDetail(
        id: String,
        onSuccess: (PhotoVO) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getSearchPhoto(id: String): List<PhotoVO>

}