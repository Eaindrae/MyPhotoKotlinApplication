package com.padcmyanmar.padc9.myphotokotlinapplication.network

import com.padcmyanmar.padc9.myphotokotlinapplication.data.vos.PhotoVO
import com.padcmyanmar.padc9.myphotokotlinapplication.utils.GET_PHOTO_DETAIL
import com.padcmyanmar.padc9.myphotokotlinapplication.utils.GET_PHOTO_LIST
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*

interface PhotoApi {

    @GET(GET_PHOTO_LIST)
    fun getAllPhotos(): Call<List<PhotoVO>>

    @GET(GET_PHOTO_LIST)
    fun getAllPhotosObservable(): Observable<List<PhotoVO>>

    @GET(GET_PHOTO_DETAIL)
    fun getPhotoDetail(@Path("id") id: String): Call<PhotoVO>
}