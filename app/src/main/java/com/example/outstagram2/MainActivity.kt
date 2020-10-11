package com.example.outstagram2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        go_login_act.setOnClickListener {
            // var : 변수 값이 언제든지 변경될 수 있음
            // val : 변수 값이 한번 정해지면 변경될 수 없음

            val intent = Intent(this, LoginActivity::class.java) // 다음 화면으로 이동하기 위한 객체 생성

            startActivity(intent)   // intent에 저장되어있는 액티비티 쪽으로 이동한다.

        }
    }
}