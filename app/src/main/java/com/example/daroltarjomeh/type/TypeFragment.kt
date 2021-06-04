package com.example.daroltarjomeh.type

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.daroltarjomeh.R
import com.example.daroltarjomeh.more.MoreFragment

class TypeFragment : Fragment() {

    companion object {
        fun getInstance() = TypeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_type, container, false)
        return view
    }
}