package jp.cordea.designwithcoroutine.ui.region

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.cordea.designwithcoroutine.di.FragmentScope

@Module
interface RegionFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [
        RegionNavigatorModule::class
    ])
    fun contributeRegionFragment(): RegionFragment
}
