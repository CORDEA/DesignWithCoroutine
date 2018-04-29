package jp.cordea.designwithcoroutine.ui.region

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import jp.cordea.designwithcoroutine.api.response.Region
import jp.cordea.designwithcoroutine.di.FragmentScope
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

@FragmentScope
class RegionViewModel @Inject constructor(
        private val repository: RegionRepository
) : ViewModel() {

    private val job = Job()
    private val mutableRegions = MutableLiveData<List<Region>>()
    val regions: LiveData<List<Region>> = mutableRegions

    fun fetchRegion() = launch(parent = job) {
        repository.fetchRegion(true).let {
            if (it.isNotEmpty()) {
                launch(UI) {
                    mutableRegions.value = it
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}
