package jp.cordea.designwithcoroutine.ui.regiondetail

import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import jp.cordea.designwithcoroutine.R
import kotlinx.android.synthetic.main.activity_region_detail.*
import javax.inject.Inject

class RegionDetailActivity : AppCompatActivity() {

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

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_region_detail)
        setSupportActionBar(toolbar)

        viewModel.regions.observe(this, Observer {
        })

        viewModel.fetchRegion()
    }
}
