package jp.cordea.designwithcoroutine.ui.regiondetail

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import jp.cordea.designwithcoroutine.api.response.Region
import jp.cordea.designwithcoroutine.ui.region.RegionRepository
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class RegionDetailViewModel : ViewModel() {

    @Inject
    lateinit var repository: RegionRepository

    private val job = Job()
    private val mutableRegions = MutableLiveData<List<Region>>()
    val regions: LiveData<List<Region>> = mutableRegions

    fun fetchRegion() = launch(parent = job) {
        repository.fetchRegion(false).let {
            if (it.isNotEmpty()) {
                mutableRegions.value = it
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}
