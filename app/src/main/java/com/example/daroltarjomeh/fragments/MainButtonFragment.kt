package com.example.daroltarjomeh.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.daroltarjomeh.R
import kotlinx.android.synthetic.main.fragment_main_button.view.*

class MainButtonFragment constructor() :
    Fragment(),
    View.OnClickListener {

    var click: onButtonClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_main_button, container, false)
        view.displayLoginTextView.setBackgroundColor(
            ContextCompat.getColor(view.context, R.color.teal_200)
        )
        view.displayRegisterTextView.setBackgroundColor(
            ContextCompat.getColor(view.context, R.color.button_off)
        )

        view.displayLoginTextView.setOnClickListener(this)
        view.displayRegisterTextView.setOnClickListener(this)

//        view.displayLoginTextView.setOnClickListener {
//            click?.setLoginListener()
//            view.displayLoginTextView.setBackgroundColor(ContextCompat.getColor(view.context, R.color.teal_200))
//            view.displayRegisterTextView.setBackgroundColor(ContextCompat.getColor(view.context, R.color.teal_700))
//        }

//        view.displayRegisterTextView.setOnClickListener {
//            click?.setRegisterListener()
//            view.displayLoginTextView.setBackgroundColor(ContextCompat.getColor(view.context, R.color.teal_700))
//            view.displayRegisterTextView.setBackgroundColor(ContextCompat.getColor(view.context, R.color.teal_200))
//
//        }

        return view
    }

    override fun onClick(v: View?) {

        when(v!!.id) {
            R.id.displayLoginTextView -> {
                click?.onLoginClicked(v)

                view?.displayLoginTextView?.setBackgroundColor(
                    ContextCompat.getColor(view?.context!!, R.color.teal_200)
                )

                view?.displayRegisterTextView?.setBackgroundColor(
                    ContextCompat.getColor(view?.context!!, R.color.button_off)
                )

                view?.displayRegisterTextView?.setTextColor(
                    ContextCompat.getColor(view?.context!!, R.color.text_off)
                )

                view?.displayLoginTextView?.setTextColor(
                    ContextCompat.getColor(view?.context!!, R.color.white)
                )
            }

            R.id.displayRegisterTextView -> {
                click?.onRegisterClicked(v.displayRegisterTextView)

                view?.displayLoginTextView?.setBackgroundColor(
                    ContextCompat.getColor(view?.context!!, R.color.button_off)
                )

                view?.displayLoginTextView?.setTextColor(
                    ContextCompat.getColor(view?.context!!, R.color.text_off)
                )

                view?.displayRegisterTextView?.setTextColor(
                    ContextCompat.getColor(view?.context!!, R.color.white)
                )

                view?.displayRegisterTextView?.setBackgroundColor(
                    ContextCompat.getColor(view?.context!!, R.color.teal_200)
                )

            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        this.createCallbackToParentActivity()
    }

    fun createCallbackToParentActivity() {
        click = activity as onButtonClickListener
    }
    interface onButtonClickListener {
        fun onLoginClicked(view: View?)
        fun onRegisterClicked(view: View?)
    }
}
