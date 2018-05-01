package jp.cordea.designwithcoroutine.di

import dagger.Binds
import dagger.Module
import jp.cordea.designwithcoroutine.ui.app.AppDataSource
import jp.cordea.designwithcoroutine.ui.app.AppRemoteDataSource
import jp.cordea.designwithcoroutine.ui.region.RegionDataSource
import jp.cordea.designwithcoroutine.ui.region.RegionRemoteDataSource

@Module
interface DataSourceModule {

    @Binds
    fun bindRegionDataSource(remoteDataSource: RegionRemoteDataSource): RegionDataSource

    @Binds
    fun bindAppDataSource(remoteDataSource: AppRemoteDataSource): AppDataSource
}
