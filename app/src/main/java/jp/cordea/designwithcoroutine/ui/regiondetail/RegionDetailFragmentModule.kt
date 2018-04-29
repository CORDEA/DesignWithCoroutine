package jp.cordea.designwithcoroutine.ui.regiondetail

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.cordea.designwithcoroutine.di.FragmentScope
import jp.cordea.designwithcoroutine.di.ViewModelModule

@Module
interface RegionDetailFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [
        RegionDetailFragmentViewModelModule::class
    ])
    fun contributeRegionDetailFragment(): RegionDetailFragment
}

@Module
class RegionDetailFragmentViewModelModule : ViewModelModule<RegionDetailFragmentViewModel>(
        RegionDetailFragmentViewModel::class
)
