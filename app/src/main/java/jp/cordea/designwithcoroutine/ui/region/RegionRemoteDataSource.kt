package jp.cordea.designwithcoroutine.ui.region

import jp.cordea.designwithcoroutine.api.VultrApiClient
import jp.cordea.designwithcoroutine.api.response.Region
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RegionRemoteDataSource @Inject constructor(
        private val apiClient: VultrApiClient
) : RegionDataSource {

    override suspend fun fetchRegion(): List<Region> =
            apiClient.getRegions().map { it.value }
}
