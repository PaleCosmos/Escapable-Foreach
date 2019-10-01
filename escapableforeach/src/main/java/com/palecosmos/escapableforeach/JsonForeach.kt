package com.palecosmos.escapableforeach

import org.json.JSONArray

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
