package jp.cordea.designwithcoroutine.ui.app

import jp.cordea.designwithcoroutine.api.VultrApiClient
import jp.cordea.designwithcoroutine.api.response.Application
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRemoteDataSource @Inject constructor(
        private val apiClient: VultrApiClient
) : AppDataSource {

    override suspend fun fetchApp(): List<Application> =
            apiClient.getApps().map { it.value }
}
