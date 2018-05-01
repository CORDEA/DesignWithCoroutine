package jp.cordea.designwithcoroutine.ui.app

import jp.cordea.designwithcoroutine.api.response.Application

interface AppDataSource {

    suspend fun fetchApp(): List<Application>
}
