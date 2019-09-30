package com.palecosmos.escapableforeach

import org.json.JSONArray

inline fun JSONArray?.escapableForEach(Do: (index: Int, value: Any?) -> Boolean) {
    if (this != null)
        loop@ for (st in 0 until length()) {
            if (!Do(st, get(st))) break@loop
        }
}

inline fun <reified T> JSONArray?.escapableCatingForEach(Do: (index: Int, value: T?) -> Boolean) {
    if (this != null)
        loop@ for (st in 0 until length()) {
            if (get(st) is T) {
                if (!Do(st, get(st) as T)) break@loop
            }else{
                continue@loop
            }
        }
}