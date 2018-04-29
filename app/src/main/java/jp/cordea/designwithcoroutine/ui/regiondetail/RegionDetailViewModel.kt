package jp.cordea.designwithcoroutine.ui.regiondetail

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import jp.cordea.designwithcoroutine.CompletableLiveData
import jp.cordea.designwithcoroutine.api.response.Region
import jp.cordea.designwithcoroutine.di.ActivityScope
import jp.cordea.designwithcoroutine.ui.region.RegionRepository
import javax.inject.Inject

@ActivityScope
class RegionDetailViewModel @Inject constructor(
        private val repository: RegionRepository
) {

    fun regions(): LiveData<List<Region>> =
            LiveDataReactiveStreams.fromPublisher(repository.getRegions())

    fun fetchRegion(): LiveData<Unit> =
            CompletableLiveData.fromCompletable(
                    repository.fetchRegion(false).ignoreElement()
            )
}
