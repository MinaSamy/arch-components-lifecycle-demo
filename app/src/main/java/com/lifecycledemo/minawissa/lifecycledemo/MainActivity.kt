package com.lifecycledemo.minawissa.lifecycledemo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lifeCycleObserver = MyLifeCycleObserver(lifecycle)
        lifecycle.addObserver(lifeCycleObserver)

        val intentButton = findViewById<Button>(R.id.button_intent)
        intentButton.setOnClickListener({
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://developer.android.com/index.html"))
            startActivity(intent)
        })
    }
}
