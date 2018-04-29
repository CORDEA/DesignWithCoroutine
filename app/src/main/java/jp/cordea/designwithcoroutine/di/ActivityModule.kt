package jp.cordea.designwithcoroutine.di

import dagger.Module
import jp.cordea.designwithcoroutine.ui.login.LoginActivityModule
import jp.cordea.designwithcoroutine.ui.main.MainActivityModule
import jp.cordea.designwithcoroutine.ui.regiondetail.RegionDetailActivityModule

@Module(includes = [
    MainActivityModule::class,
    LoginActivityModule::class,
    RegionDetailActivityModule::class
])
class ActivityModule
