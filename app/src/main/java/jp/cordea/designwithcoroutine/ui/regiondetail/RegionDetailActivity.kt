package jp.cordea.designwithcoroutine.ui.regiondetail

import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import jp.cordea.designwithcoroutine.R
import jp.cordea.designwithcoroutine.databinding.ActivityRegionDetailBinding
import javax.inject.Inject

class RegionDetailActivity : AppCompatActivity(), HasSupportFragmentInjector {

    companion object {

        private const val POSITION_KEY = "position"

        fun createIntent(context: Context, position: Int): Intent =
                Intent(context, RegionDetailActivity::class.java).apply {
                    putExtra(POSITION_KEY, position)
                }
    }

    @Inject
    lateinit var viewModel: RegionDetailViewModel

    @Inject
    lateinit var adapter: RegionDetailFragmentPagerAdapter

    @Inject
    lateinit var supportFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityRegionDetailBinding>(
                this,
                R.layout.activity_region_detail
        )
        setSupportActionBar(binding.toolbar)

        viewModel.regions.observe(this, Observer {
            it?.let {
                adapter.items = it
            }
        })

        binding.content!!.viewPager.also {
            it.adapter = adapter
            it.pageMargin = resources.getDimensionPixelSize(
                    R.dimen.activity_region_detail_view_pager_margin
            )
        }
        viewModel.fetchRegion()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> =
            supportFragmentInjector
}
