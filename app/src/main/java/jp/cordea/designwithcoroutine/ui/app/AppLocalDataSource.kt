package jp.cordea.designwithcoroutine.ui.app

import jp.cordea.designwithcoroutine.api.response.Application
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppLocalDataSource @Inject constructor(
) : AppDataSource {

    private var apps: List<Application>? = null

    fun cacheApp(apps: List<Application>) {
        this.apps = apps
    }

    override suspend fun fetchApp(): List<Application> =
            apps ?: emptyList()
}
