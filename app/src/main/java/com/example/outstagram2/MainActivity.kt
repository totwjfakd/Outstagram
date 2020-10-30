package com.example.outstagram2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.outstagram2.navigation.AlarmFragment
import com.example.outstagram2.navigation.DetailViewFragment
import com.example.outstagram2.navigation.GridFragment
import com.example.outstagram2.navigation.UserFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottom_navigation.setOnNavigationItemSelectedListener(this)
        // 첫화면은 home화면으로 설정
        var detailViewFragment = DetailViewFragment()
        supportFragmentManager.beginTransaction().replace(R.id.main_content, detailViewFragment).commit()



        /*
        go_login_act.setOnClickListener {
            // var : 변수 값이 언제든지 변경될 수 있음
            // val : 변수 값이 한번 정해지면 변경될 수 없음

            val intent = Intent(this, LoginActivity::class.java) // 다음 화면으로 이동하기 위한 객체 생성

            startActivity(intent)   // intent에 저장되어있는 액티비티 쪽으로 이동한다.

        }

         */
    }

    // Main 화면 fragment 출력 함수
    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when(p0.itemId) {
            R.id.action_home -> {
                var detailViewFragment = DetailViewFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content, detailViewFragment).commit()
                return true
            }

            R.id.action_search -> {
                var gridFragment = GridFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content, gridFragment).commit()
                return true
            }

            R.id.action_add_photo -> {
            }

            R.id.action_favorite_alarm -> {
                var alarmFragment = AlarmFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content, alarmFragment).commit()
                return true
            }

            R.id.action_account -> {
                var userFragment = UserFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content, userFragment).commit()
                return true
            }
        }
        return false
    }


}