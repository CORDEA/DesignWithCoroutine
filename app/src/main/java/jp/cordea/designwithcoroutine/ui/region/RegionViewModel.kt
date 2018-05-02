package jp.cordea.designwithcoroutine.ui.region

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import jp.cordea.designwithcoroutine.api.response.Region
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class RegionViewModel : ViewModel() {

    @Inject
    lateinit var repository: RegionRepository

    @Inject
    lateinit var navigator: RegionNavigator

    private val job = Job()
    private val mutableRegions = MutableLiveData<List<Region>>()
    val regions: LiveData<List<Region>> = mutableRegions

    fun fetchRegion() = launch(parent = job) {
        repository.fetchRegion(false).let {
            if (it.isNotEmpty()) {
                launch(UI) {
                    mutableRegions.value = it
                }
            }
        }
    }

    fun registerItemClick(channel: ReceiveChannel<Int>) = launch(UI) {
        navigator.navigateToDetail(channel.receive())
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}
