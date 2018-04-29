package jp.cordea.designwithcoroutine

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.disposables.Disposable
import java.util.concurrent.atomic.AtomicReference

fun LiveData<Unit>.observe(owner: LifecycleOwner) =
        this.observe(owner, Observer { })

class CompletableLiveData(
        private val completable: Completable
) : LiveData<Unit>() {

    companion object {

        fun fromCompletable(completable: Completable) =
                CompletableLiveData(completable)
    }

    private val subscriber = AtomicReference<LiveDataSubscriber>()

    override fun onActive() {
        super.onActive()
        LiveDataSubscriber().let {
            subscriber.set(it)
            completable.subscribe(it)
        }
    }

    override fun onInactive() {
        super.onInactive()
        subscriber.getAndSet(null)?.cancelSubscription()
    }

    inner class LiveDataSubscriber : AtomicReference<Disposable?>(), CompletableObserver {

        override fun onSubscribe(d: Disposable) {
            if (!compareAndSet(null, d)) {
                d.dispose()
            }
        }

        override fun onError(e: Throwable) {
            subscriber.compareAndSet(this, null)
        }

        override fun onComplete() {
            postValue(Unit)
            subscriber.compareAndSet(this, null)
        }

        fun cancelSubscription() {
            get()?.dispose()
        }
    }
}
