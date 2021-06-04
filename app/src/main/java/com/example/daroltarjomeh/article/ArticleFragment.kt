package com.example.daroltarjomeh.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.daroltarjomeh.R
import com.example.daroltarjomeh.more.MoreFragment

class ArticleFragment : Fragment() {

    companion object {
        fun getInstance() = ArticleFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_article, container, false)
        return view
    }
}