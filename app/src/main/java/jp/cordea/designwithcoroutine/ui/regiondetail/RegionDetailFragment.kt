package jp.cordea.designwithcoroutine.ui.regiondetail

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import dagger.android.support.AndroidSupportInjection
import jp.cordea.designwithcoroutine.api.response.Region

class RegionDetailFragment : Fragment() {

    companion object {

        private const val REGION_KEY = "region"

        fun newInstance(region: Region): RegionDetailFragment =
                RegionDetailFragment().apply {
                    arguments = Bundle().apply {
                        putParcelable(REGION_KEY, region)
                    }
                }
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
