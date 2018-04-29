package jp.cordea.designwithcoroutine.ui.region

import com.xwray.groupie.databinding.BindableItem
import jp.cordea.designwithcoroutine.R
import jp.cordea.designwithcoroutine.databinding.ListItemRegionBinding
import javax.inject.Inject

class RegionItem @Inject constructor(
        private val navigator: RegionNavigator
) : BindableItem<ListItemRegionBinding>() {

    private lateinit var viewModel: RegionItemViewModel

    fun setViewModel(viewModel: RegionItemViewModel) = apply {
        this.viewModel = viewModel
    }

    override fun getLayout(): Int =
            R.layout.list_item_region

    override fun bind(viewBinding: ListItemRegionBinding, position: Int) {
        viewBinding.vm = viewModel
        viewBinding.root.setOnClickListener {
            navigator.navigateToDetail(position)
        }
    }
}
