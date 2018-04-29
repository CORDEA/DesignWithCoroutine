package jp.cordea.designwithcoroutine.ui.login

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.cordea.designwithcoroutine.di.ActivityScope

@Module
interface LoginActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [
        LoginNavigatorModule::class
    ])
    fun contributeLoginActivity(): LoginActivity
}
