package jp.cordea.designwithcoroutine.ui.login

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.cordea.designwithcoroutine.di.ActivityScope
import jp.cordea.designwithcoroutine.di.ViewModelModule

@Module
interface LoginActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [
        LoginActivityBindsModule::class,
        LoginViewModelModule::class
    ])
    fun contributeLoginActivity(): LoginActivity
}

@Module
class LoginViewModelModule : ViewModelModule<LoginViewModel>(LoginViewModel::class)
