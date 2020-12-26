package com.example.outstagram2.navigation

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.outstagram2.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_add_photo.*
import java.text.SimpleDateFormat
import java.util.*

class AddPhotoActivity : AppCompatActivity() {
    var PICK_IMAGE_FROM_ALBUM = 0
    var storage : FirebaseStorage? = null
    var photoUri : Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_photo)

        storage = FirebaseStorage.getInstance()
        // 액티비티 실행하자마자 오픈
        var photoPickerIntent = Intent(Intent.ACTION_PICK)
        startActivityForResult(photoPickerIntent, PICK_IMAGE_FROM_ALBUM)

        // 업로드 이벤트

        addphoto_btn_upload.setOnClickListener {
            contentUPload()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_FROM_ALBUM) {
            if (resultCode == Activity.RESULT_OK) {
                photoUri = data?.data
                addphoto_image.setImageURI(photoUri)
            }
            else {
                finish()
            }
        }
    }
    fun contentUPload() {
        // 파일 이름 만들기

        var timestamp = SimpleDateFormat("yyyyMMdd_HHmmss".format(Date()))
        var imageFileName = "IMAGE_" + timestamp + "_.png"

        var storageRef = storage?.reference?.child("image")?.child(imageFileName)
        // 업로드 실패

        storageRef?.putFile(photoUri!!)?.addOnSuccessListener {
            Toast.makeText(this, getString(R.string.upload_success), Toast.LENGTH_LONG).show()
        }

    }
}