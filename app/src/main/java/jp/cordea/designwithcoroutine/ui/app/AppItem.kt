package jp.cordea.designwithcoroutine.ui.app

import com.xwray.groupie.databinding.BindableItem
import jp.cordea.designwithcoroutine.R
import jp.cordea.designwithcoroutine.databinding.ListItemAppBinding
import javax.inject.Inject

class AppItem @Inject constructor(
) : BindableItem<ListItemAppBinding>() {

    lateinit var viewModel: AppItemViewModel

    override fun getLayout(): Int =
            R.layout.list_item_app

    override fun bind(viewBinding: ListItemAppBinding, position: Int) {
        viewBinding.vm = viewModel
    }
}
