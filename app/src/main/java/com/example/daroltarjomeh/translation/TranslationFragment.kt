package com.example.daroltarjomeh.translation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.daroltarjomeh.R
import com.example.daroltarjomeh.more.MoreFragment
import kotlinx.android.synthetic.main.fragment_translation.view.*
import kotlin.reflect.KClass

class TranslationFragment : Fragment(), View.OnClickListener {

    var click: onButtonTranslationListener ?= null

    companion object {
        fun getInstance() = TranslationFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_translation, container, false)
        view.generalTranslationConstraintLayout.setOnClickListener(this)
        return view
    }

    interface onButtonTranslationListener {
        fun onGeneralClicked()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        click = activity as onButtonTranslationListener
    }

    override fun onClick(v: View?) {

        when(v?.id) {
            R.id.generalTranslationConstraintLayout -> {
                click?.onGeneralClicked()
            }
        }
    }
}