package jp.cordea.designwithcoroutine.ui.regiondetail

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.cordea.designwithcoroutine.di.ActivityScope
import jp.cordea.designwithcoroutine.di.ViewModelModule

@Module
interface RegionDetailActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [
        RegionDetailViewModelModule::class,
        RegionDetailAdapterModule::class,
        RegionDetailFragmentModule::class,
        RegionDetailActivityBindsModule::class
    ])
    fun contributeRegionDetailActivity(): RegionDetailActivity
}

@Module
class RegionDetailViewModelModule : ViewModelModule<RegionDetailViewModel>(
        RegionDetailViewModel::class
)
