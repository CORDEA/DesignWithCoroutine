package jp.cordea.designwithcoroutine.ui.regiondetail

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.cordea.designwithcoroutine.di.ActivityScope

@Module
interface RegionDetailActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [
        RegionDetailAdapterModule::class,
        RegionDetailBindModule::class
    ])
    fun contributeRegionDetailActivity(): RegionDetailActivity
}
