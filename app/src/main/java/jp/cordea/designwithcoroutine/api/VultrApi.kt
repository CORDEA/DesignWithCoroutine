package jp.cordea.designwithcoroutine.api

import jp.cordea.designwithcoroutine.api.response.Application
import jp.cordea.designwithcoroutine.api.response.Region
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET

interface VultrApi {

    @GET("v1/regions/list")
    fun getRegions(): Deferred<Map<String, Region>>

    @GET("v1/app/list")
    fun getApps(): Deferred<Map<String, Application>>
}
