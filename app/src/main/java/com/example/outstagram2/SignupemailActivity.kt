package com.example.outstagram2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_signupemail.*

class SignupemailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signupemail)



        btn_next_mail.setOnClickListener {
            if (et_user_name.text.toString() == "") {
                Toast.makeText(this, "이름을 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                val intentToPassword = Intent(this, SignuppasswordActivity::class.java)
                intentToPassword.putExtra("nameValue", et_user_name.text.toString())
                startActivity(intentToPassword)
            }
        }
    }
}