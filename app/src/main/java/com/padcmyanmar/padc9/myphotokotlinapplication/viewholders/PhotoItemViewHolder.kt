package com.padcmyanmar.padc9.myphotokotlinapplication.viewholders

import android.view.View
import coil.api.load

import com.padcmyanmar.padc9.myphotokotlinapplication.components.DynamicImageView
import com.padcmyanmar.padc9.myphotokotlinapplication.data.vos.PhotoVO
import com.padcmyanmar.padc9.myphotokotlinapplication.delegates.ItemClicked
import kotlinx.android.synthetic.main.photo_item_view.view.*

class PhotoItemViewHolder(itemView: View, private val delegate: ItemClicked) : BaseViewHolder<PhotoVO>(itemView) {

    private val photoView: DynamicImageView = itemView.photo_iv

    init {
        itemView.photo_iv.setOnClickListener {
            data?.id?.let { id ->
                delegate.onItemClicked(id)
            }
        }
    }

    override fun bindData(data: PhotoVO) {
        photoView.heightRatio = data.heightRatio
        photoView.load(data.photoUrlVO.regular)
    }
}