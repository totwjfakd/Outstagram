package com.example.outstagram2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.btn_signup
import kotlinx.android.synthetic.main.activity_login.go_main_act
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_signuppassword.*

class LoginActivity : AppCompatActivity() {
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()
        fun signinFun(email : String, password : String) {
            auth?.signInWithEmailAndPassword(email, password)
                ?.addOnCompleteListener(this){
                    if(it.isSuccessful){
                        val intentToMain = Intent(this, MainActivity::class.java) // 다음 화면으로 이동하기 위한 객체 생성
                        startActivity(intentToMain)   // intent에 저장되어있는 액티비티 쪽으로 이동한다.
                        Log.d("debug msg Login", "mes Login Success")
                        //로그인 성공시 이벤트발생
                    }else{
                        Log.d("debug msg Login", "mes Login Failed")
                        //로그인 실패시 이벤트 발생
                    }
                }
            }

        btn_login.setEnabled(false)
        et_password.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) { // 입력이 끝날때 실행되는 함수
                if (et_email.text.toString() == "" || et_password.text.toString() == "") {
                    btn_login.setEnabled(false)
                    btn_login.setBackgroundResource(R.drawable.button_colorchange)
                    //btn_next_mail.setBackground(ContextCompat.getDrawable(this, R.drawable.button_colorchange))
                    //btn_next_mail.layout(R.drawable.button_colorchange)
                    //btn_next_mail.setBackgroundColor(R.drawable.button_colorchange)
                } else {
                    btn_login.setEnabled(true)
                    btn_login.setBackgroundResource(R.drawable.button_colorchange2)
                    //btn_next_mail.setBackground(ContextCompat.getDrawable(this, R.drawable.button_colorchange2))
                    //btn_next_mail.layout(R.drawable.button_colorchange2)
                    //btn_next_mail.setBackgroundColor(R.drawable.button_colorchange2)

                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { // 입력하기 전에 실행되는 함수
                btn_login.setEnabled(false)
                //btn_next_mail.setBackgroundColor(R.drawable.button_colorchange2)
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) { // 타이핑 되는 텍스트에 변화가 있을때
                //btn_next_mail.setBackgroundColor(R.drawable.button_colorchange2)
                if (et_email.text.toString() == "" || et_password.text.toString() == "") {
                    btn_login.setEnabled(false)
                    btn_login.setBackgroundResource(R.drawable.button_colorchange)
                    //btn_next_mail.setBackground(ContextCompat.getDrawable(this, R.drawable.button_colorchange))

                    //btn_next_mail.layout(R.drawable.button_colorchange)
                    //btn_next_mail.setBackgroundColor(R.drawable.button_colorchange)
                } else {
                    btn_login.setEnabled(true)
                    btn_login.setBackgroundResource(R.drawable.button_colorchange2)
                    //btn_next_mail.setBackground(ContextCompat.getDrawable(this, R.drawable.button_colorchange2))
                    //btn_next_mail.layout(R.drawable.button_colorchange2)
                    //btn_next_mail.setBackgroundColor(R.drawable.button_colorchange2)
                }
            }
        })
        btn_login.setOnClickListener {
            signinFun(et_email.text.toString(), et_password.text.toString())

        }
        go_main_act.setOnClickListener {
            // var : 변수 값이 언제든지 변경될 수 있음
            // val : 변수 값이 한번 정해지면 변경될 수 없음

            val intentToMain2 = Intent(this, MainActivity::class.java) // 다음 화면으로 이동하기 위한 객체 생성
            startActivity(intentToMain2)   // intent에 저장되어있는 액티비티 쪽으로 이동한다.

        }
        btn_signup.setOnClickListener {

            val intentToSignupemail = Intent(this, SignupemailActivity::class.java)

            startActivity((intentToSignupemail))
        }
    }
}