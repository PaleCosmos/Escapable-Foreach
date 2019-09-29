package com.palecosmos.example.escapableforeach

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.palecosmos.escapableforeach.Dictionary
import com.palecosmos.escapableforeach.escapableForEach

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sd = HashMap<String, String>()
        sd.escapableForEach { index, key, value -> true }
        val cd = HashSet<String>()
        cd.escapableForEach { index, value ->
            true
        }
        Dictionary<String, String>().escapableForeach { index, key, value -> true }
        ArrayList<String>().asReversed()
    }
}
