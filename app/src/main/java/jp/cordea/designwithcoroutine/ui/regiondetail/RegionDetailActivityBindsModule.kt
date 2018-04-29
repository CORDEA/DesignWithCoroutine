package jp.cordea.designwithcoroutine.ui.regiondetail

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.ViewModelStoreOwner
import dagger.Binds
import dagger.Module

@Module
interface RegionDetailActivityBindsModule {

    @Binds
    fun bindLifecycleOwner(activity: RegionDetailActivity): LifecycleOwner

    @Binds
    fun bindViewModelStoreOwner(activity: RegionDetailActivity): ViewModelStoreOwner
}
