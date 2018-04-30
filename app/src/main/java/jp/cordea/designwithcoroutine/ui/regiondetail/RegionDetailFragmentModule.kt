package jp.cordea.designwithcoroutine.ui.regiondetail

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.cordea.designwithcoroutine.di.FragmentScope

@Module
interface RegionDetailFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector
    fun contributeRegionDetailFragment(): RegionDetailFragment
}
