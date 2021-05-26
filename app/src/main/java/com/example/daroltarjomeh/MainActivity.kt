package com.example.daroltarjomeh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PatternMatcher
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    var auth: FirebaseAuth? = null
    var email: EditText? = null
    var password: EditText? = null
    var collectValueRegisterButton: Button? = null
    var showMessageResultTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()
        email = findViewById(R.id.emailEditText)
        password = findViewById(R.id.passwordEditText)
        showMessageResultTextView = findViewById(R.id.showMessageResultTextView)
        collectValueRegisterButton = findViewById(R.id.collectValueRegisterButton)

        collectValueRegisterButton!!.setOnClickListener {
            registerUser()
        }
    }

    fun registerUser() {
        var users: Users? = null
        var getEmailEditText = email?.text.toString().trim()
        var getPasswordEditText = password?.text.toString().trim()

        if (getEmailEditText.isEmpty()) {
            email!!.error = "Email is required !!"
            email!!.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(getEmailEditText).matches()) {
            email!!.setError("Provide valid email")
            email!!.requestFocus()
            return
        }

        if (getPasswordEditText.isEmpty()) {
            password!!.error = "Password is required !!"
            password!!.requestFocus()
            return
        }

        if (getPasswordEditText.length < 4) {
            password!!.error = "Password should be 4 character"
            password!!.requestFocus()
            return
        }
        auth?.createUserWithEmailAndPassword(getEmailEditText, getPasswordEditText)
            ?.addOnCompleteListener { task ->
                if (task.isSuccessful)
                    Toast.makeText(this@MainActivity, "User has been registered", Toast.LENGTH_LONG)
                else
                    showMessageResultTextView?.text = task.exception.toString()

            }
//        auth?.createUserWithEmailAndPassword(
//            getEmailEditText, getPasswordEditText
//        )?.addOnCompleteListener { task ->
//            if (task.isSuccessful) {
//                Toast.makeText(this@MainActivity, "User has been registered", Toast.LENGTH_LONG)
//                    .show()
//                users = Users(getEmailEditText)
//            } else {
//                Toast.makeText(this@MainActivity, "" + task.exception?.message, Toast.LENGTH_LONG).show()

//            }

//            FirebaseDatabase.getInstance().getReference("Users")
//                .child(FirebaseAuth.getInstance().currentUser!!.uid)
//                .setValue(users).addOnCompleteListener { task ->
//                    if (task.isSuccessful)
//                        Toast.makeText(this@MainActivity, "User has been registered",Toast.LENGTH_LONG).show()
//                    else
//                        Toast.makeText(this@MainActivity, "Failed to register !!",Toast.LENGTH_LONG).show()

//                }
//        }
    }
}


data class Users(var email: String)