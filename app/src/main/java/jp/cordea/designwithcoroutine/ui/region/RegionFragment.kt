package jp.cordea.designwithcoroutine.ui.region


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
import jp.cordea.designwithcoroutine.ChannelObserver
import jp.cordea.designwithcoroutine.databinding.FragmentRegionBinding
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import javax.inject.Inject
import javax.inject.Provider

class RegionFragment : Fragment() {

    companion object {

        fun newInstance(): RegionFragment =
                RegionFragment()
    }

    @Inject
    lateinit var viewModel: RegionViewModel

    @Inject
    lateinit var item: Provider<RegionItem>

    @Inject
    lateinit var channelObserver: ChannelObserver

    private val adapter by lazy {
        GroupAdapter<ViewHolder>()
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.regions
                .observe(this, Observer {
                    it?.let {
                        adapter.clear()
                        adapter.addAll(
                                it.map { item.get().setViewModel(RegionItemViewModel.from(it)) }
                        )
                    }
                })
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRegionBinding.inflate(inflater, container, false)
        binding.recyclerView.adapter = adapter
        viewModel.registerItemClick(adapter.bindItemClick(channelObserver.job))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchRegion()
    }

    private fun GroupAdapter<ViewHolder>.bindItemClick(
            job: Job
    ): ReceiveChannel<Int> {
        val channel = Channel<Int>()
        setOnItemClickListener { item, _ ->
            if (!channel.isClosedForSend) {
                channel.offer(getAdapterPosition(item))
            }
        }
        job.invokeOnCompletion {
            setOnItemClickListener(null)
            channel.close()
        }
        return channel
    }
}
