package com.palecosmos.escapableforeach

inline fun <T> List<T>?.escapableForEach(Do: (index: Int, value: T?) -> Boolean) {
    if (this != null)
        loop@ for (st in 0 until size) {
            if (!Do(st, this[st])) break@loop
        }
}

inline fun <T> Set<T>?.escapableForEach(Do: (index: Int, value: T?) -> Boolean) {
    var count = 0
    if (this != null)
        loop@ for (thing in this) {
            if (!Do(count, thing)) break@loop
            count++
        }
}

inline fun <T, S> Map<T, S>?.escapableForEach(Do: (index: Int, key: T?, value: S?) -> Boolean) {
    var count = 0
    if (this != null)
        loop@ for (thing in this) {
            if (!Do(count, thing.key, thing.value)) break@loop
            count++
        }
}