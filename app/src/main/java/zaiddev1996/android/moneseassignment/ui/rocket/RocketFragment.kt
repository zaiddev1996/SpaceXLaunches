package zaiddev1996.android.moneseassignment.ui.rocket

import android.animation.Animator
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import zaiddev1996.android.moneseassignment.databinding.FragmentRocketBinding

@AndroidEntryPoint
class RocketFragment : Fragment() {


    private var _binding: FragmentRocketBinding? = null
    private val binding get() = _binding!!

    private val rocketViewModel: RocketViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            FragmentRocketBinding
                .inflate(
                    inflater,
                    container,
                    false
                )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListeners()
        setObservers()
    }

    private fun setObservers() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                rocketViewModel.rocketStateFlow.collect {
                    when (it) {
                        is RocketViewModel.RocketState.Success -> {
                            binding.animationView.cancelAnimation()
                            binding.tvRocketName.text = it.data.name
                            binding.tvCompanyName.text = it.data.company
                            val height = "${it.data.height!!.feet}ft"
                            binding.tvHeight.text = height
                            val diameter = "${it.data.diameter!!.feet}ft"
                            binding.tvDiameter.text = diameter
                            val mass = "${it.data.mass!!.kg}kg"
                            binding.tvMass.text = mass
                            binding.tvDesc.text = it.data.description
                            Glide.with(requireContext())
                                .load(it.data.flickrImages[0])
                                .into(binding.sivRocket)
                        }

                        is RocketViewModel.RocketState.Loading -> {
                            if (it.loading) {
                                binding.animationView.playAnimation()
                            } else {
                                binding.animationView.cancelAnimation()
                            }

                        }
                        else -> {}
                    }
                }


            }

        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                rocketViewModel.errorSharedFlow.collect {
                    binding.animationView.cancelAnimation()
                    Toast.makeText(
                        requireContext(),
                        it,
                        Toast.LENGTH_LONG
                    )
                        .show()
                }
            }
        }
    }

    private fun setListeners() {
        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.animationView.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                binding.animationView.visibility = View.VISIBLE
            }

            override fun onAnimationEnd(animation: Animator) {


            }

            override fun onAnimationCancel(p0: Animator) {

                binding.animationView.visibility = View.GONE
            }

            override fun onAnimationRepeat(p0: Animator) {
            }


        })
    }

}