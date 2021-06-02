package com.example.daroltarjomeh.fragments

import android.os.Bundle
import android.text.Editable
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.daroltarjomeh.R
import kotlinx.android.synthetic.main.fragment_edittext.view.*

class EditTextFragment : Fragment() {

    private var email: EditText? = null
    private var password: EditText? = null
    private var emailValue: String? = null
    private var passswordValue: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_edittext, container, false)

        email = view.emailEditText
        password = view.passwordEditText

        emailValue = email?.text.toString()
        passswordValue = password?.text.toString()

        return view
    }

    fun emailValidation() {
        if (emailValue?.isEmpty() == true) {
            email!!.error = "Email is required !!"
            email!!.requestFocus()
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(emailValue).matches()) {
            email!!.error = "Provide valid email"
            email!!.requestFocus()
        }

        fun passwordValidation() {
            if (passswordValue?.isEmpty() == true) {
                password!!.error = "Password is required !!"
                password!!.requestFocus()
            }

            if (passswordValue?.length!! < 4) {
                password!!.error = "Password should be 4 character"
                password!!.requestFocus()
            }
        }
    }

    fun getEmailText(): String = email?.text.toString()

    fun getPasswordText(): String = password?.text.toString()
}