package jp.cordea.designwithcoroutine.ui.app

import jp.cordea.designwithcoroutine.api.response.Application
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepository @Inject constructor(
        private val dataSource: AppDataSource,
        private val localDataSource: AppLocalDataSource
) {

    suspend fun fetchApp(forceFetch: Boolean): List<Application> =
            if (forceFetch) {
                dataSource.fetchApp()
            } else {
                localDataSource.fetchApp().run {
                    if (isEmpty()) {
                        dataSource.fetchApp().also {
                            if (it.isNotEmpty()) {
                                localDataSource.cacheApp(it)
                            }
                        }
                    } else {
                        this
                    }
                }
            }
}
