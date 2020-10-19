package com.example.outstagram2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

import kotlinx.android.synthetic.main.activity_signupemail.*
import kotlinx.android.synthetic.main.activity_signuppassword.*
import kotlinx.android.synthetic.main.activity_welcome.*



class SignuppasswordActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signuppassword)

        auth = FirebaseAuth.getInstance()


        fun signupFun(email : String, password : String) {

                //val email: String = intent.getStringExtra("nameValue").toString()
                //val password: String = et_user_password.text.toString()

                Log.d("debug msg", "\"$email, $password\"")
                auth?.createUserWithEmailAndPassword(email, password)
                    ?.addOnCompleteListener(this) { task: Task<AuthResult> ->
                        if (task.isSuccessful) {
                            Log.d("debug msg2", "mes Success")
                            val user = auth?.currentUser
                            //task.result?.user
                        }
                        else if (!task.isSuccessful) {
                            Log.e("ERROR MSG", "onComplete: Failed=" + task.exception)
                        }
                        else {
                            Log.d("debug msg2", "mes Fail")
                            Toast.makeText(this, task.exception?.message, Toast.LENGTH_LONG)
                                .show()

                    }
                }
            }


        btn_next_password.setEnabled(false)
        et_user_password.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) { // 입력이 끝날때 실행되는 함수
                if (et_user_password.text.toString() == "") {
                    btn_next_password.setEnabled(false)
                    btn_next_password.setBackgroundResource(R.drawable.button_colorchange)
                    //btn_next_mail.setBackground(ContextCompat.getDrawable(this, R.drawable.button_colorchange))
                    //btn_next_mail.layout(R.drawable.button_colorchange)
                    //btn_next_mail.setBackgroundColor(R.drawable.button_colorchange)
                } else {
                    btn_next_password.setEnabled(true)
                    btn_next_password.setBackgroundResource(R.drawable.button_colorchange2)
                    //btn_next_mail.setBackground(ContextCompat.getDrawable(this, R.drawable.button_colorchange2))
                    //btn_next_mail.layout(R.drawable.button_colorchange2)
                    //btn_next_mail.setBackgroundColor(R.drawable.button_colorchange2)

                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { // 입력하기 전에 실행되는 함수
                btn_next_password.setEnabled(false)
                //btn_next_mail.setBackgroundColor(R.drawable.button_colorchange2)
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) { // 타이핑 되는 텍스트에 변화가 있을때
                //btn_next_mail.setBackgroundColor(R.drawable.button_colorchange2)
                if (et_user_password.text.toString() == "") {
                    btn_next_password.setEnabled(false)
                    btn_next_password.setBackgroundResource(R.drawable.button_colorchange)
                    //btn_next_mail.setBackground(ContextCompat.getDrawable(this, R.drawable.button_colorchange))

                    //btn_next_mail.layout(R.drawable.button_colorchange)
                    //btn_next_mail.setBackgroundColor(R.drawable.button_colorchange)
                } else {
                    btn_next_password.setEnabled(true)
                    btn_next_password.setBackgroundResource(R.drawable.button_colorchange2)
                    //btn_next_mail.setBackground(ContextCompat.getDrawable(this, R.drawable.button_colorchange2))
                    //btn_next_mail.layout(R.drawable.button_colorchange2)
                    //btn_next_mail.setBackgroundColor(R.drawable.button_colorchange2)
                }
            }
        })
        btn_next_password.setOnClickListener {
            if (intent.hasExtra("nameValue")) {
                signupFun(
                    intent.getStringExtra("nameValue").toString(),
                    et_user_password.text.toString()
                )
                val intentToWelcome = Intent(this, WelcomeActivity::class.java)
                intentToWelcome.putExtra("nameValue", intent.getStringExtra("nameValue"))
                startActivity(intentToWelcome)
            }
        }

        }
    }