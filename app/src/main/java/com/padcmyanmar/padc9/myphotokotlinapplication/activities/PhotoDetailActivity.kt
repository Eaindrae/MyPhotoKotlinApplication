package com.padcmyanmar.padc9.myphotokotlinapplication.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import coil.api.load
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import com.padcmyanmar.padc9.myphotokotlinapplication.R
import com.padcmyanmar.padc9.myphotokotlinapplication.adapters.PhotoItemAdapter
import com.padcmyanmar.padc9.myphotokotlinapplication.data.vos.PhotoVO
import com.padcmyanmar.padc9.myphotokotlinapplication.mvp.presenters.PhotoDetailPresenter
import com.padcmyanmar.padc9.myphotokotlinapplication.mvp.presenters.PhotoListPresenter
import com.padcmyanmar.padc9.myphotokotlinapplication.mvp.views.PhotoDetailView
import com.padcmyanmar.padc9.myphotokotlinapplication.mvp.views.PhotoListView
import kotlinx.android.synthetic.main.activity_bottom_sheet.*
import kotlinx.android.synthetic.main.activity_photo_detail.*

class PhotoDetailActivity: BaseActivity(), PhotoDetailView, PhotoListView {

    override fun displayPhotoDetail(photoVO: PhotoVO) {
        bindData(photoVO)
    }

    override fun displayPhotoList(photoList: List<PhotoVO>) {
        photoItemAdapter.setNewData(photoList.toMutableList())
    }

    override fun displayError(errorMessage: String) {
       Snackbar.make(rootView, errorMessage, Snackbar.LENGTH_LONG).show()
    }

    override fun navigateToDetail(photoId: String) {
        startActivity(newIntent(applicationContext, photoId))
    }

    override fun errorMessage(errorMessage: String) {
   Snackbar.make(rootView, errorMessage, Snackbar.LENGTH_LONG).show()
    }

    private lateinit var photoDetailPresenter: PhotoDetailPresenter
    private lateinit var photoListPresenter: PhotoListPresenter
    private lateinit var photoItemAdapter: PhotoItemAdapter
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_photo_detail)

        photoDetailPresenter = PhotoDetailPresenter()
        photoDetailPresenter.initPresenter(this)

        photoListPresenter = PhotoListPresenter()
        photoListPresenter.initPresenter(this)

        bottomSheetBehavior = BottomSheetBehavior.from(bottomsheet)

        bottomSheetBehavior.setBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(@NonNull view: View, i: Int) {
                when (i) {
                    BottomSheetBehavior.STATE_HIDDEN -> {
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
                        bottomSheetBehavior.setPeekHeight(300)
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                    }
                }
            }

            override fun onSlide(@NonNull view: View, v: Float) {

            }
        })

        photoItemAdapter = PhotoItemAdapter(photoListPresenter)
        with(rv_related_photos){
            setHasFixedSize(true)
            layoutManager = androidx.recyclerview.widget.StaggeredGridLayoutManager(
                2,
                androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
            )
            adapter = photoItemAdapter
        }

        val photoId = intent.getStringExtra(EXTRA_PHOTO_ID)
        photoDetailPresenter.onUiReady(this, photoId!!)
        photoListPresenter.onUiReady(this)

    }

    companion object {
        const val EXTRA_PHOTO_ID = "photo_id"

        fun newIntent(context: Context, photo_id: String): Intent {

            return Intent(context, PhotoDetailActivity::class.java).apply {
                putExtra(EXTRA_PHOTO_ID, photo_id)
            }
        }
    }

    fun bindData(data: PhotoVO){
        photo_detail_iv.load(data.photoUrlVO.regular)
        user_iv.load(data.userVO.profileImageVO!!.medium)
        user_tv.text = data.userVO.name
        user_account_tv.text = "@" + data.userVO.twitter_username
    }
}
