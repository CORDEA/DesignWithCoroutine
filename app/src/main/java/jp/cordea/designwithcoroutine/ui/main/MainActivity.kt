package jp.cordea.designwithcoroutine.ui.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import jp.cordea.designwithcoroutine.R
import jp.cordea.designwithcoroutine.databinding.ActivityMainBinding
import jp.cordea.designwithcoroutine.ui.app.AppFragment
import jp.cordea.designwithcoroutine.ui.region.RegionFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity(),
        NavigationView.OnNavigationItemSelectedListener,
        HasSupportFragmentInjector {

    @Inject
    lateinit var supportFragmentInjector: DispatchingAndroidInjector<Fragment>

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_main
        )
        setSupportActionBar(binding.appBar!!.toolbar)

        val toggle = ActionBarDrawerToggle(
                this,
                binding.drawerLayout,
                binding.appBar!!.toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navView.setNavigationItemSelectedListener(this)

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, RegionFragment.newInstance())
                .commit()
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val transaction = supportFragmentManager.beginTransaction()
        when (item.itemId) {
            R.id.nav_camera ->
                transaction.replace(R.id.container, RegionFragment.newInstance())
            R.id.nav_gallery ->
                transaction.replace(R.id.container, AppFragment.newInstance())
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }
        transaction.commit()
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> =
            supportFragmentInjector
}
