package jp.cordea.designwithcoroutine.ui.regiondetail

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection
import jp.cordea.designwithcoroutine.api.response.Region
import jp.cordea.designwithcoroutine.databinding.FragmentRegionDetailBinding
import javax.inject.Inject

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

    @Inject
    lateinit var viewModel: RegionDetailFragmentViewModel

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.update(arguments!!.getParcelable(REGION_KEY))
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View =
            FragmentRegionDetailBinding.inflate(inflater, container, false).apply {
                vm = viewModel
            }.root
}
