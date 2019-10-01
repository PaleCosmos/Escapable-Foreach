package com.palecosmos.example.escapableforeach

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.palecosmos.escapableforeach.*
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val array = arrayOf("")
        val arrayList = ArrayList<String>()
        val list = List(0) { i -> "$i" }
        val jsonArray = JSONArray()

        array.escapableForEach { index, value ->
            if (index > 3) return@escapableForEach BREAK
            function(index, value)
            return@escapableForEach CONTINUE
        }
        arrayList.escapableForEach { index, value ->
            if (index > 3) return@escapableForEach BREAK
            function(index, value)
            return@escapableForEach CONTINUE
        }
        list.escapableForEach { index, value ->
            if (index > 3) return@escapableForEach BREAK
            function(index, value)
            return@escapableForEach CONTINUE
        }
        jsonArray.escapableForEach<String> { index, value ->
            if (index > 3) return@escapableForEach BREAK
            function(index, value)
            return@escapableForEach CONTINUE
        }


    }

    fun function(a: Int, b: String?) {

    }
}
