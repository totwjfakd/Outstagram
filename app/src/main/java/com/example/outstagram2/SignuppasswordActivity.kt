package com.example.outstagram2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_signupemail.*
import kotlinx.android.synthetic.main.activity_signuppassword.*
import kotlinx.android.synthetic.main.activity_welcome.*

class SignuppasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signuppassword)

        btn_next_password.setOnClickListener {
            if (et_user_password.text.toString() == "") {
                Toast.makeText(this, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                val intentToWelcome = Intent(this, WelcomeActivity::class.java)
                if (intent.hasExtra("nameValue")) {
                    intentToWelcome.putExtra("nameValue", intent.getStringExtra("nameValue"))
                }
                startActivity(intentToWelcome)
            }
        }

    }
}