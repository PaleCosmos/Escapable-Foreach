package com.palecosmos.example.escapableforeach

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.palecosmos.escapableforeach.*
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dictionary = Dictionary(arrayOf(0, 1, 2, 3, 4, 5)) { i ->
            "$i"
        }

        dictionary.escapableForeach { index, key, value ->
            if (index < 1 || key == 3) return@escapableForeach CONTINUE

            if (value == null) return@escapableForeach BREAK

            CONTINUE
        }


    }
}
