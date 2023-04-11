package com.starthub.securityApp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.starthub.securityApp.OnBoardItem
import com.starthub.securityApp.databinding.OnboardingItemBinding

class OnBoardingAdapter(private val context: Context, onBoardItems: ArrayList<OnBoardItem>) : PagerAdapter() {

    private var onBoardItems = ArrayList<OnBoardItem>()

    init {
        this.onBoardItems = onBoardItems
    }

    override fun getItemPosition(`object`: Any): Int {
        val index: Int =
            onBoardItems.indexOf(`object`)
        return if (index == -1) POSITION_NONE else index
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return onBoardItems.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView = LayoutInflater.from(container.context)
        val binding = OnboardingItemBinding.inflate(itemView, container, false)
        val item = onBoardItems[position]
        binding.apply {
            img.setImageResource(item.image)
            tvTitle.text = item.title
            tvDescription.text = item.description
        }
        //container.removeView(binding.root)
        container.addView(binding.root)
        container.childCount -1
        return binding.root

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
        //super.destroyItem(container, position, `object`)

    }

    fun removeView(pager: ViewPager, view: View?): Int {
        return removeView(pager, onBoardItems.indexOf<Any?>(view))
    }


    fun removeView(pager: ViewPager, position: Int): Int {
        pager.adapter = null
        this.onBoardItems.clear()
        pager.adapter = this
        return position
    }

    fun clear(){
        this.onBoardItems.clear()
    }

}

//class OnBoardingAdapter(private val image: ArrayList<Int>):RecyclerView.Adapter<OnBoardingAdapter.ViewPagerViewHolder>() {
//    init {
//
//    }
//   inner class ViewPagerViewHolder (itemView:View):RecyclerView.ViewHolder(itemView){
//       val imageView:ImageView =itemView.findViewById(R.id.imageView)
//       val imageView3:ImageView = itemView.findViewById(R.id.imageView3)
//       val imageView4:ImageView = itemView.findViewById(R.id.imageView4)
//
//   }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingAdapter.ViewPagerViewHolder {
//        val view=LayoutInflater.from(parent.context).inflate(R.layout.fragment_onboarding,parent,false)
//        return ViewPagerViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: OnBoardingAdapter.ViewPagerViewHolder, position: Int) {
//
//
//
//    }
//
//    override fun getItemCount(): Int {
//        return image.size
//    }
//
//}