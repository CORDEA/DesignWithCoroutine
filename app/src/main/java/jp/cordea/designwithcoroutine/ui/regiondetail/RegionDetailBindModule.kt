package jp.cordea.designwithcoroutine.ui.regiondetail

import android.arch.lifecycle.LifecycleOwner
import dagger.Binds
import dagger.Module

@Module
interface RegionDetailBindModule {

    @Binds
    fun bindLifecycleOwner(activity: RegionDetailActivity): LifecycleOwner
}
