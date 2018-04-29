package jp.cordea.designwithcoroutine.ui.region

import jp.cordea.designwithcoroutine.api.response.Region

interface RegionDataSource {

    suspend fun fetchRegion(): List<Region>
}
