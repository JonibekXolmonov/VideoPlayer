package com.example.videoplayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import net.alhazmy13.mediapicker.Video.VideoPicker

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        findViewById<Button>(R.id.btn_play_video).setOnClickListener {
            pickVideo()
        }
    }

    private fun pickVideo() {
        val videoPicker = VideoPicker.Builder(this)
            .mode(VideoPicker.Mode.GALLERY)
            .directory(VideoPicker.Directory.DEFAULT)
            .extension(VideoPicker.Extension.MP4)
            .enableDebuggingMode(true)

        videoPicker.build()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == VideoPicker.VIDEO_PICKER_REQUEST_CODE && requestCode == RESULT_OK) {
            val videoPaths = data?.getIntegerArrayListExtra(VideoPicker.EXTRA_VIDEO_PATH)
            Log.d("videoPaths", "onActivityResult: $videoPaths")
        }
    }
}