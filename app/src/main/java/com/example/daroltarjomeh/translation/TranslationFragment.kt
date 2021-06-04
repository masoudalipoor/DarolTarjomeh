package com.example.daroltarjomeh.translation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.daroltarjomeh.R
import com.example.daroltarjomeh.more.MoreFragment

class TranslationFragment : Fragment() {

    companion object {
        fun getInstance() = TranslationFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_translation, container, false)
        return view
    }
}