package com.example.myfaceviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.view.ViewTreeObserver.OnGlobalLayoutListener

import android.view.ViewTreeObserver


class MainActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "MainActivity"
    }

    private lateinit var button: Button
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        textView = findViewById(R.id.text)

        Log.d(
            TAG,
            "1 onWindowFocusChanged: buttonWidth:${button.width}, textViewWidth:${textView.width}"
        )

        button.post {
            Log.d(
                TAG,
                "5 onWindowFocusChanged: buttonWidth:${button.width}, textViewWidth:${textView.width}"
            )
        }


    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        Log.d(TAG, "onWindowFocusChanged: hasFocus:$hasFocus")
        if (hasFocus) {
            Log.d(
                TAG,
                "onWindowFocusChanged: buttonWidth:${button.width}, textViewWidth:${textView.width}"
            )
            Log.d(
                TAG,
                "onWindowFocusChanged: buttonMeasuredWidth:${button.measuredWidth}, textViewMeasuredWidth:${textView.measuredWidth}"
            )
        }
    }


    override fun onStart() {
        super.onStart()
        button.viewTreeObserver.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                button.viewTreeObserver.removeOnGlobalLayoutListener(this)
                Log.d(
                    TAG,
                    "viewTreeObserver onStart: buttonWidth:${button.width}, textViewWidth:${textView.width}"
                )
            }
        })

    }
}


