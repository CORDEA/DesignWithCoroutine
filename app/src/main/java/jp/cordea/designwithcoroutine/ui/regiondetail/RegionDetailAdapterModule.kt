package jp.cordea.designwithcoroutine.ui.regiondetail

import android.support.v4.app.FragmentManager
import dagger.Module
import dagger.Provides
import jp.cordea.designwithcoroutine.di.ActivityScope

@Module
class RegionDetailAdapterModule {

    @Provides
    @ActivityScope
    fun provideFragmentManager(activity: RegionDetailActivity): FragmentManager =
            activity.supportFragmentManager
}
