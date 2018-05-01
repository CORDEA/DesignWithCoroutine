package jp.cordea.designwithcoroutine.ui.app


import android.arch.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection
import jp.cordea.designwithcoroutine.databinding.FragmentAppBinding
import javax.inject.Inject

class AppFragment : Fragment() {

    companion object {

        fun newInstance(): AppFragment =
                AppFragment()
    }

    @Inject
    lateinit var viewModel: AppViewModel

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.apps
                .observe(this, Observer {
                    it?.let {
                    }
                })
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val binding = FragmentAppBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchActor.offer(FetchAppMsg.Fetch)
    }
}
