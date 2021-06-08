package com.example.daroltarjomeh.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.daroltarjomeh.R
import kotlinx.android.synthetic.main.fragment_button.*
import kotlinx.android.synthetic.main.fragment_button.view.*

class ButtonFragment : Fragment(), View.OnClickListener {

    var click: onButtonCompleteClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_button, container, false)

        setUp(view)

        return view
    }

    private fun setUp(view: View) {
//        view.loginButton.visibility = View.VISIBLE
//        view.registerButton.visibility = View.GONE
        view.loginButton.setOnClickListener(this)
    }

    interface onButtonCompleteClickListener {
        fun onLoginCompleteClicked()
        fun onRegisterCompleteClicked()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.createCallbackToParentActivity()
    }

    fun createCallbackToParentActivity() {
        click = activity as onButtonCompleteClickListener
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.loginButton -> {
                if (requireView().loginButton.text.equals("ثبت نام")) {
                    click?.onRegisterCompleteClicked()
                } else if (requireView().loginButton.text.equals("ورود")) {
                    click?.onLoginCompleteClicked()
                }
            }

//            R.id.registerButton -> {
//                click?.onRegisterCompleteClicked()
//            }
        }
    }
    
    fun getTextTitle(name: String): String {
        requireView().loginButton.text = ""
        requireView().loginButton.text = name
        return name
    }
}