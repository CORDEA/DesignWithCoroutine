package jp.cordea.designwithcoroutine.ui.app

import android.arch.lifecycle.ViewModelStoreOwner
import dagger.Binds
import dagger.Module

@Module
interface AppFragmentBindsModule {

    @Binds
    fun bindViewModelStoreOwner(fragment: AppFragment): ViewModelStoreOwner
}
