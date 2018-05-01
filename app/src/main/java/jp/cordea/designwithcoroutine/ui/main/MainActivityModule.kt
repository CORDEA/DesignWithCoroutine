package jp.cordea.designwithcoroutine.ui.main

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.cordea.designwithcoroutine.di.ActivityScope
import jp.cordea.designwithcoroutine.ui.app.AppFragmentModule
import jp.cordea.designwithcoroutine.ui.region.RegionFragmentModule

@Module
interface MainActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [
        RegionFragmentModule::class,
        AppFragmentModule::class
    ])
    fun contributeMainActivity(): MainActivity
}
