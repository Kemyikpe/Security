package com.starthub.securityApp.mainActivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.starthub.securityApp.R
import com.starthub.securityApp.adapter.OnBoardingAdapter
import com.starthub.securityApp.databinding.FragmentOnboardingBinding

/**
 * A simple [Fragment] subclass.
 * Use the [OnBoardingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OnBoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingBinding
    private lateinit var onboardingAdapter: OnBoardingAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        viewPager = binding.viewPagerLayout
        onboardingAdapter = OnBoardingAdapter()
        binding.viewPagerLayout.adapter = onboardingAdapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            TabLayoutMediator(tabLayout, viewPagerLayout) { tab, position ->
            }.attach()

            viewPagerLayout.registerOnPageChangeCallback(object :
                ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)

                    skipBtn.setOnClickListener {
                        findNavController().navigate(R.id.action_onBoardingFragment_to_loginFragment)
                    }

                    nextBtn.setOnClickListener {
                        val current = (viewPagerLayout.currentItem) + 1
                        viewPagerLayout.currentItem = current
                        if (current == MAX_STEP) {
                            findNavController().navigate(R.id.action_onBoardingFragment_to_loginFragment)
                        }
                    }
                }
            })
        }
    }

    companion object {
        const val MAX_STEP = 3
    }

}
