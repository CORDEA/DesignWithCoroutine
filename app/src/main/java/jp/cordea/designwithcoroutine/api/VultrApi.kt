package jp.cordea.designwithcoroutine.api

import io.reactivex.Maybe
import jp.cordea.designwithcoroutine.api.response.Region
import retrofit2.http.GET

interface VultrApi {

    @GET("v1/regions/list")
    fun getRegions(): Maybe<Map<String, Region>>
}
