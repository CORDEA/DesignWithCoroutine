package jp.cordea.designwithcoroutine.ui.region

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import jp.cordea.designwithcoroutine.CompletableLiveData
import jp.cordea.designwithcoroutine.api.response.Region
import jp.cordea.designwithcoroutine.di.FragmentScope
import javax.inject.Inject

@FragmentScope
class RegionViewModel @Inject constructor(
        private val repository: RegionRepository
) {

    fun regions(): LiveData<List<Region>> =
            LiveDataReactiveStreams.fromPublisher(repository.getRegions())

    fun fetchRegion(): LiveData<Unit> =
            CompletableLiveData.fromCompletable(
                    repository.fetchRegion(true).ignoreElement()
            )
}
