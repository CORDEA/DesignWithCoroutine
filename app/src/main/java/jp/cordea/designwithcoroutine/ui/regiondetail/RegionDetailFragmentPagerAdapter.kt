package jp.cordea.designwithcoroutine.ui.regiondetail

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import jp.cordea.designwithcoroutine.api.response.Region
import jp.cordea.designwithcoroutine.di.ActivityScope
import javax.inject.Inject

@ActivityScope
class RegionDetailFragmentPagerAdapter @Inject constructor(
        fragmentManager: FragmentManager
) : FragmentPagerAdapter(fragmentManager) {

    private var items: List<Region> = emptyList()

    override fun getItem(position: Int): Fragment =
            RegionDetailFragment.newInstance(items[position])

    override fun getCount(): Int =
            items.size
}
