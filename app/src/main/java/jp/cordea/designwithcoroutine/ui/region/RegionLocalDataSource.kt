package jp.cordea.designwithcoroutine.ui.region

import io.reactivex.Maybe
import jp.cordea.designwithcoroutine.api.response.Region
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RegionLocalDataSource @Inject constructor(
) : RegionDataSource {

    private var regions: List<Region>? = null

    fun cacheRegion(regions: List<Region>) {
        this.regions = regions
    }

    override fun fetchRegion(): Maybe<List<Region>> {
        val region = regions ?: return Maybe.empty()
        return Maybe.just(region)
    }
}
