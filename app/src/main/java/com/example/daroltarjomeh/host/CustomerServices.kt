package com.example.daroltarjomeh.host

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.daroltarjomeh.R
import com.example.daroltarjomeh.adapter.ViewPagerAdapter
import com.example.daroltarjomeh.article.ArticleFragment
import com.example.daroltarjomeh.more.MoreFragment
import com.example.daroltarjomeh.translation.TranslationFragment
import com.example.daroltarjomeh.type.TypeFragment
import com.example.daroltarjomeh.utils.CustomTAbLayout
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class CustomerServices : AppCompatActivity() {

    private lateinit var activity: FragmentActivity
    private var adapter: ViewPagerAdapter? = null
//    private var taabs: CustomTAbLayout? = null
    private var tabLayout: TabLayout? = null
    private var viewpager: ViewPager? = null
    private var fragment: FragmentTransaction ?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_services)
        activity = FragmentActivity()
//        this.fragment = FragmentTransaction(
//            R.id.frm_trans,
//            this@CustomerServices
//        )

//        taabs = findViewById(R.id.tabs)
        tabLayout = findViewById(R.id.tabLayout)
        viewpager = findViewById(R.id.viewpager)
        initTablayout()
        setupViewPager()
    }

    fun initTablayout() {
        viewpager?.offscreenPageLimit = 4
        tabLayout?.addTab(tabLayout!!.newTab().setText("تایپ"))
        tabLayout?.addTab(tabLayout!!.newTab().setText("بیشتر"))
        tabLayout?.addTab(tabLayout!!.newTab().setText("مقاله"))
        tabLayout?.addTab(tabLayout!!.newTab().setText("ترجمه"))
        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL

        tabLayout?.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewpager?.setCurrentItem(tab.position, false)
                tab.setText(getTabTitle(tab.position))
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tab.text = null
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                val fragment: Fragment? = supportFragmentManager
                    .findFragmentById(R.id.frm_trans)
//                if (fragment != null) fragmentTransaction.popFromBackStack()
            }
        })


        viewpager?.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                val fragment: Fragment? = supportFragmentManager
                    .findFragmentById(R.id.frm_trans)
                if (fragment != null) {
//                    fragmentTransaction.popFromBackStack()
                }
                tabLayout?.getTabAt(position)?.select()
                when (position) {
                    0 -> {
//                        supportView.setVisibility(View.INVISIBLE)
//                        bottomSheetLayoutSupport.collapse()
                    }
                    1 -> {
//                        supportView.setVisibility(View.INVISIBLE)
//                        bottomSheetLayoutSupport.collapse()
                    }
                    2 -> {
//                        supportView.setVisibility(View.INVISIBLE)
//                        bottomSheetLayoutSupport.collapse()
                    }
                    3 -> {
//                        supportView.setVisibility(View.INVISIBLE)
//                        bottomSheetLayoutSupport.collapse()
                    }
                }
//                setTitleFragment(position)
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

    }

    fun setupViewPager() {
        adapter = ViewPagerAdapter(supportFragmentManager)
        adapter?.addFragment(MoreFragment.getInstance(), "")
        adapter?.addFragment(ArticleFragment.getInstance(), "")
//        adapter.addFragment(NewOrderFragment.getInstance(StartPageType.NEW_ORDER), "")
        adapter?.addFragment(TypeFragment.getInstance(), "")
        adapter?.addFragment(TranslationFragment.getInstance(), "")
        viewpager?.adapter = adapter
    }

    private fun getTabTitle(position: Int): Int {
        return when (position) {
            0 -> R.string.more
            1 -> R.string.translation
            2 -> R.string.article
            3 -> R.string.type
            else -> 0
        }
    }



















//    fun getTabView(i: Int): LinearLayout? {
//        if (taabs?.childCount!! > 0) {
//            if ((taabs?.getChildAt(0) as LinearLayout).childCount >= i) return ((taabs?.getChildAt(0)
//                    as LinearLayout).getChildAt(i) as LinearLayout)
//        }
//        return null
//    }
//
//    fun setTabLayoutParams(layout: LinearLayout?, wieght: Float) {
//        if (layout == null) return
//        val layoutParams = layout.layoutParams as LinearLayout.LayoutParams
//        layoutParams.weight = wieght // e.g. 0.5f
//        layout.layoutParams = layoutParams
//
//    }
}