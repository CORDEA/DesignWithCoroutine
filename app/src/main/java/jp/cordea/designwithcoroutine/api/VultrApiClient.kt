package jp.cordea.designwithcoroutine.api

import jp.cordea.designwithcoroutine.BuildConfig
import jp.cordea.designwithcoroutine.KeyManager
import jp.cordea.designwithcoroutine.api.response.Region
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VultrApiClient @Inject constructor(
        private val manager: KeyManager,
        private val retrofitBuilder: Retrofit.Builder
) {

    private val service: VultrApi?
        get() {
            val key = manager.get() ?: return null
            var builder = OkHttpClient.Builder()
                    .addInterceptor {
                        it.proceed(it.request()
                                .newBuilder()
                                .addHeader("API-Key", key)
                                .build())
                    }

            if (BuildConfig.DEBUG) {
                builder = builder
                        .addInterceptor(
                                HttpLoggingInterceptor()
                                        .setLevel(HttpLoggingInterceptor.Level.BASIC)
                        )
            }

            return retrofitBuilder
                    .client(builder.build())
                    .build()
                    .create(VultrApi::class.java)
        }

    suspend fun getRegions(): Map<String, Region> =
            service?.getRegions()?.await() ?: emptyMap()
}
