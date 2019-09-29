package com.palecosmos.example.foreach

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.palecosmos.foreach.Dictionary
import com.palecosmos.foreach.foreach
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val x = Dictionary<Int, String>()

        for (c in 0..10) {
            x.put(c, "$c")
        }

        x.foreach { k, v ->
            idid.append("$k : $v \n")
        }

        var k = x.copy()
        var v = x.deepCopy()

        var c = object : java.util.Dictionary<Int, String>() {
            override fun put(key: Int?, value: String?): String {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun isEmpty(): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun remove(key: Any?): String {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun size(): Int {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun get(key: Any?): String {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun elements(): Enumeration<String> {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun keys(): Enumeration<Int> {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }


    }
}

