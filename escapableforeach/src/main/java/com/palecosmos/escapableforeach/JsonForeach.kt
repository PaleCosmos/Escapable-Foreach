package com.palecosmos.escapableforeach

import org.json.JSONArray
import java.util.*

inline fun <reified T> JSONArray?.escapableForEach(Do: (index: Int, value: T?) -> Boolean) {
    if (this != null)
        loop@ for (st in 0 until length()) {
            if (get(st) is T) {
                if (!Do(st, get(st) as T)) break@loop
            } else {
                continue@loop
            }
        }
}

fun JSONArray?.findAllValue(): Vector<Any?> = Vector<Any?>().apply {
    findAllValue(this)
}

private fun JSONArray?.findAllValue(vector: Vector<Any?>) {
    if (this != null)
        for (st in 0 until length()) {
            val value = get(st)
            if (value is JSONArray?) {
                value.findAllValue(vector)
            } else {
                vector.add(value)
            }
        }
}