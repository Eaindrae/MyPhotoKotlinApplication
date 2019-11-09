package com.padcmyanmar.padc9.myphotokotlinapplication.network.dataagents

import com.padcmyanmar.padc9.myphotokotlinapplication.data.vos.PhotoVO
import io.reactivex.Observable

interface PhotoDataAgent {

    fun getPhotos(
        onSuccess: (List<PhotoVO>) -> Unit,
        onFailure: (String) -> Unit)

    fun getPhotosObservable(): Observable<List<PhotoVO>>

    fun getPhotoDetail(
        id: String,
        onSuccess: (PhotoVO) -> Unit,
        onFailure: (String) -> Unit
    )
}