package jp.cordea.designwithcoroutine.ui.region

import jp.cordea.designwithcoroutine.api.response.Region
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RegionRepository @Inject constructor(
        private val dataSource: RegionDataSource,
        private val localDataSource: RegionLocalDataSource
) {

    suspend fun fetchRegion(forceFetch: Boolean): List<Region> =
            if (forceFetch) {
                dataSource.fetchRegion()
            } else {
                localDataSource.fetchRegion().run {
                    if (isEmpty()) {
                        dataSource.fetchRegion().also {
                            if (it.isNotEmpty()) {
                                localDataSource.cacheRegion(it)
                            }
                        }
                    } else {
                        this
                    }
                }
            }
}
