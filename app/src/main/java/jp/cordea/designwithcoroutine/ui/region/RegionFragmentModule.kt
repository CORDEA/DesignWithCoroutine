package jp.cordea.designwithcoroutine.ui.region

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.cordea.designwithcoroutine.di.FragmentScope
import jp.cordea.designwithcoroutine.di.ViewModelModule

@Module
interface RegionFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [
        RegionFragmentBindsModule::class,
        RegionViewModelModule::class
    ])
    fun contributeRegionFragment(): RegionFragment
}

@Module
class RegionViewModelModule : ViewModelModule<RegionViewModel>(RegionViewModel::class)
