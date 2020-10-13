package com.example.outstagram2

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_signupemail.*

class SignupemailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signupemail)
        et_user_name.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) { // 입력이 끝날때 실행되는 함수
                if (et_user_name.text.toString() == "") {
                    btn_next_mail.setEnabled(false)
                    btn_next_mail.setBackgroundResource(R.drawable.button_colorchange)
                    //btn_next_mail.setBackground(ContextCompat.getDrawable(this, R.drawable.button_colorchange))
                    //btn_next_mail.layout(R.drawable.button_colorchange)
                    //btn_next_mail.setBackgroundColor(R.drawable.button_colorchange)
                } else {
                    btn_next_mail.setEnabled(true)
                    btn_next_mail.setBackgroundResource(R.drawable.button_colorchange2)
                    //btn_next_mail.setBackground(ContextCompat.getDrawable(this, R.drawable.button_colorchange2))
                    //btn_next_mail.layout(R.drawable.button_colorchange2)
                    //btn_next_mail.setBackgroundColor(R.drawable.button_colorchange2)

                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { // 입력하기 전에 실행되는 함수
                btn_next_mail.setEnabled(false)
                //btn_next_mail.setBackgroundColor(R.drawable.button_colorchange2)
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) { // 타이핑 되는 텍스트에 변화가 있을때
                //btn_next_mail.setBackgroundColor(R.drawable.button_colorchange2)
                if (et_user_name.text.toString() == "") {
                    btn_next_mail.setEnabled(false)
                    btn_next_mail.setBackgroundResource(R.drawable.button_colorchange)
                    //btn_next_mail.setBackground(ContextCompat.getDrawable(this, R.drawable.button_colorchange))

                    //btn_next_mail.layout(R.drawable.button_colorchange)
                    //btn_next_mail.setBackgroundColor(R.drawable.button_colorchange)
                } else {
                    btn_next_mail.setEnabled(true)
                    btn_next_mail.setBackgroundResource(R.drawable.button_colorchange2)
                    //btn_next_mail.setBackground(ContextCompat.getDrawable(this, R.drawable.button_colorchange2))
                    //btn_next_mail.layout(R.drawable.button_colorchange2)
                    //btn_next_mail.setBackgroundColor(R.drawable.button_colorchange2)
                }
                }
        })
        btn_next_mail.setOnClickListener {
            val intentToPassword = Intent(this, SignuppasswordActivity::class.java)
            intentToPassword.putExtra("nameValue", et_user_name.text.toString())
            startActivity(intentToPassword)
        }
    }
}