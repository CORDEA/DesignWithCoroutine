package jp.cordea.designwithcoroutine.ui.app

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import jp.cordea.designwithcoroutine.api.response.Application
import kotlinx.coroutines.experimental.CompletableDeferred
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.channels.actor
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class AppViewModel : ViewModel() {

    @Inject
    lateinit var repository: AppRepository

    private val job = Job()
    private val mutableApps = MutableLiveData<List<Application>>()
    val apps: LiveData<List<Application>> = mutableApps

    init {
        val response = CompletableDeferred<List<Application>>()
        launch(UI) {
            fetchActor.send(FetchAppMsg.GetResult(response))
            mutableApps.value = response.await()
            fetchActor.close()
        }
    }

    val fetchActor = actor<FetchAppMsg>(parent = job) {
        var result = emptyList<Application>()
        for (msg in channel) {
            when (msg) {
                FetchAppMsg.Fetch -> repository.fetchApp(false).let {
                    if (it.isNotEmpty()) {
                        result = it
                    }
                }
                FetchAppMsg.ForceFetch -> repository.fetchApp(true).let {
                    if (it.isNotEmpty()) {
                        result = it
                    }
                }
                is FetchAppMsg.GetResult -> if (result.isNotEmpty()) {
                    msg.response.complete(result)
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}
