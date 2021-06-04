package com.example.daroltarjomeh.utils

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.tabs.TabLayout
import com.google.firebase.installations.Utils
import java.lang.reflect.Field

class CustomTAbLayout constructor(context: Context) : TabLayout(context) {

    private val WIDTH_INDEX = 0
    private val DIVIDER_FACTOR = 3
    private val SCROLLABLE_TAB_MIN_WIDTH = "mScrollableTabMinWidth"

    constructor(context: Context?, attrs: AttributeSet?) : this(context!!) {
        initTabMinWidth()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : this(context!!, attrs) {
        initTabMinWidth()
    }

//    fun CustomTAbLayout(context: Context?) {
//        super(context)
//        initTabMinWidth()
//    }

//    fun CustomTAbLayout(context: Context?, attrs: AttributeSet?) {
//        super(context, attrs)
//        initTabMinWidth()
//    }

//    fun CustomTAbLayout(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) {
//        super(context, attrs, defStyleAttr)
//        initTabMinWidth()
//    }

    private fun initTabMinWidth() {
        val wh: IntArray = PublicMethod.getScreenSize(context)!!
        val tabMinWidth = wh[WIDTH_INDEX] / DIVIDER_FACTOR
        val field: Field
        try {
            field = TabLayout::class.java.getDeclaredField(SCROLLABLE_TAB_MIN_WIDTH)
            field.isAccessible = true
            field[this] = tabMinWidth
        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }
    }
}