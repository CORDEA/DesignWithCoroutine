package jp.cordea.designwithcoroutine

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import kotlinx.coroutines.experimental.Job
import javax.inject.Inject

class ChannelObserver @Inject constructor(
        lifecycle: Lifecycle
) : LifecycleObserver {
    init {
        lifecycle.addObserver(this)
    }

    val job = Job()

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        job.cancel()
    }
}
