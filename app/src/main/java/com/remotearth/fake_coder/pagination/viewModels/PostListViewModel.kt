package com.remotearth.fake_coder.pagination.viewModels

import androidx.lifecycle.MutableLiveData
import com.remotearth.fake_coder.pagination.api.APIClient
import com.remotearth.fake_coder.pagination.contracts.PostListView
import com.remotearth.fake_coder.pagination.pojos.Post
import com.remotearth.fake_coder.pagination.viewModels.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers

class PostListViewModel(private val postListView: PostListView) : BaseViewModel() {

    private val compositeDisposable = CompositeDisposable()
    var posts: MutableLiveData<List<Post>> = MutableLiveData()

    fun fetchTodoList() {
        showLoader()

        compositeDisposable += APIClient()
            .getAPIService()
            .allPosts()
            .subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribeWith(object : DisposableObserver<List<Post>>() {
                override fun onError(e: Throwable) {
                    postListView.onActionFailed(e.message.toString())
                    hideLoader()
                }

                override fun onNext(data: List<Post>) {
                    hideLoader()
                    posts.value = data
                }

                override fun onComplete() {
                    hideLoader()
                }
            })!!
    }

    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }

}
