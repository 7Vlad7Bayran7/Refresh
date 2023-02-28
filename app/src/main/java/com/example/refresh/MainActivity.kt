package com.example.refresh

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var c = 0
        val thread = object : Thread() {
            override fun run() {
                try {
                    while (!this.isInterrupted) {
                        sleep(1000)
                        runOnUiThread {
                            c++
                            findViewById<TextView>(R.id.textview_msg).text = "$c"
                            Log.i("Vlad", "$c")
                        }
                    }
                } catch (_: InterruptedException) {
                }
            }
        }
        thread.start()
    }
}