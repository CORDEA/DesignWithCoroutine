package jp.cordea.designwithcoroutine.ui.app


import android.arch.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import dagger.android.support.AndroidSupportInjection
import jp.cordea.designwithcoroutine.databinding.FragmentAppBinding
import javax.inject.Inject
import javax.inject.Provider

class AppFragment : Fragment() {

    companion object {

        fun newInstance(): AppFragment =
                AppFragment()
    }

    @Inject
    lateinit var viewModel: AppViewModel

    @Inject
    lateinit var item: Provider<AppItem>

    private val adapter by lazy {
        GroupAdapter<ViewHolder>()
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.apps
                .observe(this, Observer {
                    it?.let {
                        adapter.clear()
                        adapter.addAll(
                                it.map {
                                    item.get().apply {
                                        viewModel = AppItemViewModel.from(it)
                                    }
                                }
                        )
                    }
                })
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val binding = FragmentAppBinding.inflate(inflater, container, false)
        binding.recyclerView.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchActor.offer(FetchAppMsg.Fetch)
    }
}
