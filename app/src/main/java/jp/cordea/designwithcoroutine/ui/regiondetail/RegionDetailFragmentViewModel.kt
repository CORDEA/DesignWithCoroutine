package jp.cordea.designwithcoroutine.ui.regiondetail

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import jp.cordea.designwithcoroutine.api.response.Region
import jp.cordea.designwithcoroutine.di.FragmentScope
import javax.inject.Inject

@FragmentScope
class RegionDetailFragmentViewModel @Inject constructor(
) {

    val title = ObservableField<String>()
    val description = ObservableField<String>()
    val continent = ObservableField<String>()
    val ddosProtection = ObservableBoolean()
    val blockStorage = ObservableBoolean()

    fun update(region: Region) {
        title.set(region.name)
        description.set(region.country)
        continent.set(region.continent)
        ddosProtection.set(region.ddosProtection)
        blockStorage.set(region.blockStorage)
    }
}
