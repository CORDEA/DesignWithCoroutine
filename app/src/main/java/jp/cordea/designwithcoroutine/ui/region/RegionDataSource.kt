package jp.cordea.designwithcoroutine.ui.region

import io.reactivex.Maybe
import jp.cordea.designwithcoroutine.api.response.Region

interface RegionDataSource {

    fun fetchRegion(): Maybe<List<Region>>
}
