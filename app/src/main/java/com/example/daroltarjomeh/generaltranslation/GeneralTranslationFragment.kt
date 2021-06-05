package com.example.daroltarjomeh.generaltranslation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.daroltarjomeh.R

class GeneralTranslationFragment: Fragment()  {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_general_translation, container, false)
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}