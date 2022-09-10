package zaiddev1996.android.moneseassignment.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import zaiddev1996.android.moneseassignment.adapters.LaunchesAdapter
import zaiddev1996.android.moneseassignment.databinding.FragmentMainBinding


@AndroidEntryPoint
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var launchesAdapter: LaunchesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            FragmentMainBinding
                .inflate(
                    inflater,
                    container,
                    false
                )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(
            view,
            savedInstanceState
        )
        setListeners()
        setObservers()
        setRecyclerView()
    }

    private fun setRecyclerView() {
        launchesAdapter = LaunchesAdapter {
            val action = MainFragmentDirections.actionLaunchToRocketDetail(it.rocket!!)
            findNavController().navigate(action)
        }

        binding.rvLaunches.apply {
            layoutManager =
                LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.VERTICAL,
                    false
                )
            adapter = launchesAdapter
        }
    }

    private fun setObservers() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainViewModel.launchStateFlow.collect {
                    when (it) {
                        is MainViewModel.LaunchesState.Success -> {
                            launchesAdapter.submitList(it.data)
                            binding.animationView.visibility = View.GONE
                            binding.rvLaunches.visibility = View.VISIBLE
                        }

                        is MainViewModel.LaunchesState.Failure -> {
                            binding.animationView.visibility = View.GONE
                            binding.tvError.visibility = View.VISIBLE
                            binding.tvError.text = it.errorMessage
                        }

                        is MainViewModel.LaunchesState.Loading -> {
                            binding.rvLaunches.visibility = View.GONE
                            binding.animationView.visibility = View.VISIBLE
                            binding.tvError.visibility = View.GONE
                        }
                        else -> {}
                    }
                }
            }
        }


    }

    private fun setListeners() {
        binding.swipeRefresh.setOnRefreshListener {
            binding.swipeRefresh.isRefreshing = false
            launchesAdapter.submitList(null)
            mainViewModel.getLaunches()
        }

        binding.cbSuccessFilter.setOnCheckedChangeListener { button, checked ->
            if (!button.isPressed) {
                return@setOnCheckedChangeListener;
            }
            mainViewModel.toggleFitter(checked)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}