package jp.cordea.designwithcoroutine.ui.app

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.cordea.designwithcoroutine.di.FragmentScope
import jp.cordea.designwithcoroutine.di.ViewModelModule

@Module
interface AppFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [
        AppViewModelModule::class,
        AppFragmentBindsModule::class
    ])
    fun contributeAppFragment(): AppFragment
}

@Module
class AppViewModelModule : ViewModelModule<AppViewModel>(AppViewModel::class)
