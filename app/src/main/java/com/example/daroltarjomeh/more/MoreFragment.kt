package com.example.daroltarjomeh.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.daroltarjomeh.R

class MoreFragment : Fragment() {

    companion object {
        fun getInstance() = MoreFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_more, container, false)
        return view
    }
}