package com.padcmyanmar.padc9.myphotokotlinapplication.activities

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModelProviders
import com.padcmyanmar.padc9.myphotokotlinapplication.R
import com.padcmyanmar.padc9.myphotokotlinapplication.adapters.PhotoItemAdapter
import com.padcmyanmar.padc9.myphotokotlinapplication.data.models.PhotoListModel
import com.padcmyanmar.padc9.myphotokotlinapplication.data.models.PhotoListModelImpl
import com.padcmyanmar.padc9.myphotokotlinapplication.data.vos.PhotoVO
import com.padcmyanmar.padc9.myphotokotlinapplication.mvp.presenters.PhotoListPresenter
import com.padcmyanmar.padc9.myphotokotlinapplication.mvp.views.PhotoListView
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_photo_detail.*
import kotlinx.android.synthetic.main.activity_photo_list.*

class PhotoListActivity : BaseActivity(), PhotoListView {

    override fun displayPhotoList(photoList: List<PhotoVO>) {
        photoItemAdapter.setNewData(photoList.toMutableList())
    }

    override fun displayError(errorMessage: String) {
        Snackbar.make(rootView, errorMessage, Snackbar.LENGTH_LONG).show()
    }

    override fun navigateToDetail(photoId: String) {
        startActivity(PhotoDetailActivity.newIntent(applicationContext, photoId))
    }

    private lateinit var disposable: Disposable
    private lateinit var photoItemAdapter: PhotoItemAdapter
    private lateinit var photoListPresenter: PhotoListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_photo_list)

        photoListPresenter = ViewModelProviders.of(this).get(PhotoListPresenter::class.java)
        photoListPresenter.initPresenter(this)

        photoItemAdapter = PhotoItemAdapter(photoListPresenter)

        with(rv_photos) {
            layoutManager = androidx.recyclerview.widget.StaggeredGridLayoutManager(
                2,
                androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
            )
            setHasFixedSize(true)
            adapter = photoItemAdapter
        }

//        et_Search.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
//            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
//                val search_keyword = et_Search.text.toString()
//                return@OnEditorActionListener true
//            }
//            false
//        })
//
//        et_Search.setOnKeyListener { v, keyCode, event ->
//            if (keyCode == KeyEvent.KEYCODE_DEL) {
//                photoListPresenter.onUiReady(this)
//            }
//            false
//        }
//
//        et_Search.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
//
//            }
//
//            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
//
//            }
//
//            override fun afterTextChanged(s: Editable) {
//                searchByKeyword(s.toString())
//            }
//        })
//
  photoListPresenter.onUiReady(this)
//    }
//
//    fun searchByKeyword(keyword: String){
//        val model: PhotoListModel = PhotoListModelImpl
//        photoItemAdapter.setNewData(model.getSearchPhoto(keyword) as MutableList<PhotoVO>)
//        rv_photos.adapter = photoItemAdapter
//    }

    }
}
