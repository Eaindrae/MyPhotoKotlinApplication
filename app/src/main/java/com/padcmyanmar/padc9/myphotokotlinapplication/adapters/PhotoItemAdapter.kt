package com.padcmyanmar.padc9.myphotokotlinapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.padc9.myphotokotlinapplication.R
import com.padcmyanmar.padc9.myphotokotlinapplication.data.vos.PhotoVO
import com.padcmyanmar.padc9.myphotokotlinapplication.delegates.ItemClicked
import com.padcmyanmar.padc9.myphotokotlinapplication.viewholders.PhotoItemViewHolder

class PhotoItemAdapter(private val delegate: ItemClicked): BaseAdapter<PhotoItemViewHolder, PhotoVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoItemViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.photo_item_view, parent, false)
        return PhotoItemViewHolder(layout, delegate)
    }
}