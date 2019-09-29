package com.palecosmos.example.foreach

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.palecosmos.foreach.Dictionary

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val x = Dictionary<String, String>()
        var y = x.put("asdf", "d")

        for (s in x) {

        }


    }
}

