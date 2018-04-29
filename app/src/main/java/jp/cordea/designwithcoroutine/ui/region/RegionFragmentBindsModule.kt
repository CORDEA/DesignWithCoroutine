package jp.cordea.designwithcoroutine.ui.region

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.ViewModelStoreOwner
import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class RegionFragmentBindsModule {

    @Binds
    abstract fun bindFragment(fragment: RegionFragment): Fragment

    @Binds
    abstract fun bindViewModelStoreOwner(fragment: RegionFragment): ViewModelStoreOwner

    @Module
    companion object {

        @Provides
        @JvmStatic
        fun provideLifecycle(fragment: RegionFragment): Lifecycle =
                fragment.lifecycle
    }
}
