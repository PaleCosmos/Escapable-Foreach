package com.palecosmos.example.escapableforeach

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.palecosmos.escapableforeach.*
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val array = arrayOf("")
        val arrayList = ArrayList<String>()
        val list: List<String>? = List(0) { i -> "$i" }
        val jsonArray = JSONArray()

        Dictionary<Int, Int>().apply { put(1, 1) }.escapableForeach { index, key, value ->
            CONTINUE
        }

        array.escapableForEachNullable(
            NotNull = { index, value -> true },
            IsNull = { index -> true }
        )


        val hashMap: HashMap<String, String?>? = HashMap()

        ArrayList<Byte?>().escapableForEach { index, value -> true }

        if (hashMap != null) {
            var index = 0
            for (pair in hashMap) {
                if (pair.value != null) {
                    Log.d("LOG", "index : $index, ${pair.value}")
                    if (pair.key == "kotlin") {
                        index++
                        continue
                    }
                    if (!function(pair.key, pair.value)) {
                        break
                    }

                } else {
                    Log.d("LOG", "index : $index, isNull")
                    if (!function(pair.key)) {
                        break
                    }
                }
                index++
            }
        }

        hashMap.escapableForEachNullable(NotNull = { index, key, value ->
            Log.d("LOG", "index : $index, $value")
            if (key == "kotlin") return@escapableForEachNullable CONTINUE
            return@escapableForEachNullable function(key, value)
        },
            IsNull = { index, key ->
                Log.d("LOG", "index : $index, isNull")
                return@escapableForEachNullable function(key)
            })

    }

    fun function(a: String): Boolean {
        return true
    }

    fun function(a: Int, b: String?) {

    }

    fun function(a: String?, b: String?): Boolean {
        return true
    }
}
