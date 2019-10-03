package com.lifecycledemo.minawissa.lifecycledemo

import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
//    private lateinit var logger: MyLogger
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lifeCycleObserver = MyLifeCycleObserver(lifecycle, MyLogger())
        lifecycle.addObserver(lifeCycleObserver)

        val intentButton = findViewById<Button>(R.id.button_intent)
        intentButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(resources.getString(R.string.home_page))
            startActivity(intent)
        }
    }
}
