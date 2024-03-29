package com.example.daroltarjomeh.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.daroltarjomeh.AppDaroltarjomeh
import com.example.daroltarjomeh.R
import com.example.daroltarjomeh.db.entity.UserEntity
import com.example.daroltarjomeh.fragments.ButtonFragment
import com.example.daroltarjomeh.fragments.MainButtonFragment
import com.example.daroltarjomeh.fragments.EditTextFragment
import com.example.daroltarjomeh.host.CustomerServices
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity(),
    MainButtonFragment.onButtonClickListener, ButtonFragment.onButtonCompleteClickListener {

    private var editTextFragment: EditTextFragment? = null
    private var buttonFragment: ButtonFragment? = null
    private val mainContext = this@MainActivity

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as AppDaroltarjomeh).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainSetUp()
    }

    private fun mainSetUp() {
        signInTextView.setTextColor(ContextCompat.getColor(this, R.color.white))
        signUpTextView.setTextColor(ContextCompat.getColor(this, R.color.text_off))

        buttonFragment =
            supportFragmentManager.findFragmentById(R.id.buttonFragment) as ButtonFragment

        editTextFragment =
            supportFragmentManager.findFragmentById(R.id.editTextFragment) as EditTextFragment

        buttonFragment!!.getTextTitle("ورود")
    }

    override fun onLoginClicked(view: View?) {
        signInTextView.setTextColor(ContextCompat.getColor(this, R.color.white))
        signUpTextView.setTextColor(ContextCompat.getColor(this, R.color.text_off))
        buttonFragment!!.getTextTitle("ورود")
//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.mainFrameLayout, loginFragment!!)
//            commit()
//        }
    }

    override fun onRegisterClicked(view: View?) {
        signInTextView.setTextColor(ContextCompat.getColor(this, R.color.text_off))
        signUpTextView.setTextColor(ContextCompat.getColor(this, R.color.white))
        buttonFragment!!.getTextTitle("ثبت نام")
    }

    override fun onLoginCompleteClicked() {
        val time = measureTimeMillis {
            mainViewModel.user.observe(this) { user ->
                if (user.userEmail == editTextFragment?.getEmailText()) {
                    startActivity(Intent(this, CustomerServices::class.java))
                    finish()
                } else
                    Toast.makeText(this, "ایمیل اشتباه است", Toast.LENGTH_LONG).show()
            }
        }
        Log.e("onLoginCompleteClicked","$time")
//        startActivity(Intent(mainContext, CustomerServices::class.java))
    }

    override fun onRegisterCompleteClicked() {
        val time = measureTimeMillis {
            val userEntity = UserEntity(
                editTextFragment?.getPasswordText()!!.toLong(),
                editTextFragment?.getEmailText().toString()
            )
            mainViewModel.insert(userEntity)
        }
     Log.e("onRegisterCompleteCl","$time")
    }
}


