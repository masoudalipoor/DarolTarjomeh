package com.example.daroltarjomeh.utils

import androidx.viewpager.widget.ViewPager
import com.example.daroltarjomeh.R
import java.text.AttributedCharacterIterator

class ViewPagerPageChange constructor(var customTAbLayout: CustomTAbLayout?) : ViewPager.OnPageChangeListener {
    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

    override fun onPageSelected(position: Int) {
//        customTAbLayout?.getTabAt(position)?.select()
        when (position) {
            0 -> {
//                setSearchButtonVisibility(View.GONE)
//                setUpSettingButtonVisibility(View.GONE)
//                binding.toolbar.imgCancelOrder.setVisibility(View.GONE)
//                binding.fab.setColorFilter(Color.BLACK, PorterDuff.Mode.MULTIPLY)
//                binding.toolbar.imgSearch.setVisibility(View.GONE)
            }
            1 -> {
//                setPageTitle(R.string.main_menu_orders)

//                setSearchButtonVisibility(View.GONE)
//                setUpSettingButtonVisibility(View.GONE)
//                binding.fab.setColorFilter(Color.BLACK, PorterDuff.Mode.MULTIPLY)
//                binding.toolbar.imgSearch.setVisibility(View.GONE)
            }
            2 -> {
//                setPageTitle(R.string.new_order_select_origin)

//                binding.fab.setColorFilter(
//                    ContextCompat.getColor(
//                        getFragmentActivity(),
//                        R.color.colorPrimary
//                    )
//                )
            }
            3 -> {
//                setSearchButtonVisibility(View.GONE)
//                setUpSettingButtonVisibility(View.GONE)

//                setPageTitle(R.string.main_menu_finance_report)

//                binding.fab.setColorFilter(Color.BLACK, PorterDuff.Mode.MULTIPLY)
//                binding.toolbar.imgSearch.setVisibility(View.GONE)
            }
//            4 -> {
//                setSearchButtonVisibility(View.GONE)
//                setUpSettingButtonVisibility(View.GONE)

//                setPageTitle(R.string.main_menu_work_report)

//                binding.fab.setColorFilter(Color.BLACK, PorterDuff.Mode.MULTIPLY)
//                binding.toolbar.imgSearch.setVisibility(View.GONE)
//            }
            else -> {
            }
        }
    }

    override fun onPageScrollStateChanged(state: Int) {}
}