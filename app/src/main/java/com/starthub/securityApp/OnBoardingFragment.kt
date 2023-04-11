package com.starthub.securityApp

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.content.res.AppCompatResources
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.starthub.securityApp.Adapter.OnBoardingAdapter
import com.starthub.securityApp.databinding.FragmentOnboardingBinding
import com.starthub.securityApp.utils.Animation

/**
 * A simple [Fragment] subclass.
 * Use the [OnBoardingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OnBoardingFragment : Fragment() {
    private var binding: FragmentOnboardingBinding? = null
    private var dotCount: Int = 0
    private lateinit var dots: ArrayList<ImageView>
    private lateinit var onboardingAdapter : OnBoardingAdapter
    private var onBoardItems: ArrayList<OnBoardItem> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOnboardingBinding.inflate(inflater,container,false)
        val  view = inflater.inflate(R.layout.fragment_onboarding,container,false)
        return  view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewPager()

        //onBoardPager = view.findViewById(R.id.viewPagerLayout)
        binding?.apply {
            skipBtn.setOnClickListener {
               findNavController().navigate(R.id.onboarding_to_signUp_graph)
            }

            nextBtn.setOnClickListener {
                if (getItem(+1) > viewPagerLayout.childCount-1) {
                    Animation.animateSlideLeft(requireContext())
                } else {
                    viewPagerLayout.setCurrentItem(getItem(+1), true)   //currentItem = getItem(+1)
                }
            }
        }

        setPageViewController()
    }

    private fun initViewPager(){
        loadData()
        onboardingAdapter =
            OnBoardingAdapter(
                requireContext(),
                onBoardItems
            )
        binding?.apply {
            viewPagerLayout.adapter = onboardingAdapter
            viewPagerLayout.currentItem = 0
            viewPagerLayout.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
                override fun onPageScrollStateChanged(state: Int) {
                }

                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                }

                override fun onPageSelected(position: Int) {
                    for (i in 0 until dotCount){
                        dots[i].setImageDrawable(
                            AppCompatResources.getDrawable(
                                requireContext(),
                                R.drawable.unselected_dot
                            ))
                        dots[position].setImageDrawable(
                            AppCompatResources.getDrawable(
                                requireContext(),
                                R.drawable.selected_dot
                            ))
                    }
                }
            })
        }

    }

    private fun loadData(){

        val onboardingTitleList = listOf(
            R.string.onboarding_title1,
            R.string.onboarding_title2,
            R.string.onboarding_title3
        )

        val onboardingDescriptionList = listOf(
            R.string.onboarding_description1,
            R.string.onboarding_description2,
            R.string.onboarding_description3
        )
        val onboardingImageList = listOf(
            R.drawable.onboarding_image1,
            R.drawable.onboarding_image2,
            R.drawable.onboarding_image3
        )

        for (i in onboardingImageList.indices){
            val item = OnBoardItem()
            item.image = onboardingImageList[i]
            item.title = resources.getString(onboardingTitleList[i])
            item.description = resources.getString(onboardingDescriptionList[i])
            onBoardItems.add(item)
        }
    }

    private fun setPageViewController(){
        dotCount = onboardingAdapter.count
        dots = ArrayList(dotCount)
        for (i in 0 until dotCount){
            dots.add(i, ImageView(requireContext()))
            dots[i].setImageDrawable(AppCompatResources.getDrawable(
                requireContext(),
                R.drawable.unselected_dot
            ))
            val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            params.setMargins(6, 0, 6, 0)
            binding?.viewPagerCounter?.addView(dots[i], params)
        }
        dots[0].setImageDrawable(
            AppCompatResources.getDrawable(
                requireContext(),
            R.drawable.selected_dot
        ))

    }

    private fun getItem(i: Int): Int {
        return binding?.viewPagerLayout?.currentItem?.plus(i) ?: 1
    }

}

class OnBoardItem {
    var image: Int = 0
    var title: String = ""
    var description:String = ""
}