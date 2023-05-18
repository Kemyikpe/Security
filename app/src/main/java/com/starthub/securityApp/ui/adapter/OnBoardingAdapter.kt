package com.starthub.securityApp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.starthub.securityApp.ui.onboarding.OnBoardingFragment.Companion.MAX_STEP
import com.starthub.securityApp.R
import com.starthub.securityApp.databinding.OnboardingItemBinding

class OnBoardingAdapter : RecyclerView.Adapter<OnBoardingAdapter.OnBoardingPagerViewHolder>() {

    class OnBoardingPagerViewHolder(val binding: OnboardingItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingPagerViewHolder {
        return OnBoardingPagerViewHolder(
            OnboardingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    //get the size of color array
    override fun getItemCount(): Int = MAX_STEP // Int.MAX_VALUE

    //binding the screen with view
    override fun onBindViewHolder(holder: OnBoardingPagerViewHolder, position: Int) = holder.itemView.run {

        with(holder) {
            if (position == 0) {
                binding.tvTitle.text = context.getString(R.string.onboarding_title1)
                binding.tvDescription.text = context.getString(R.string.onboarding_description1)
                binding.img.setImageResource(R.drawable.onboarding_image1)
            }
            if (position == 1) {
                binding.tvTitle.text = context.getString(R.string.onboarding_title2)
                binding.tvDescription.text = context.getString(R.string.onboarding_description2)
                binding.img.setImageResource(R.drawable.onboarding_image2)
            }
            if (position == 2) {
                binding.tvTitle.text = context.getString(R.string.onboarding_title3)
                binding.tvDescription.text = context.getString(R.string.onboarding_description3)
                binding.img.setImageResource(R.drawable.onboarding_image3)
            }
        }
    }
}
