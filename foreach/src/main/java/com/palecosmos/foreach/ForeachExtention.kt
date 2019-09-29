package com.palecosmos.foreach

inline fun <T> Array<T?>?.foreach(Do: ((i: Int, value: T?) -> Unit)) {
    if (this != null)
        for (st in 0 until size) {
            Do(st, this[st])
        }
}

inline fun <T> ArrayList<T?>?.foreach(Do: ((i: Int, value: T?) -> Unit)) {
    if (this != null)
        for (st in 0 until size) {
            Do(st, this[st])
        }
}

inline fun <T> List<T?>?.foreach(Do: ((i: Int, value: T?) -> Unit)) {
    if (this != null)
        for (st in 0 until size) {
            Do(st, this[st])
        }
}

inline fun <T, S> Map<T?, S?>?.foreach(Do: ((i: Int, key: T?, value: S?) -> Unit)) {
    if (this != null) {
        var count = 0
        for (thing in this) {
            Do(count, thing.key, thing.value)
            count++
        }
    }
}

inline fun <T> Set<T?>?.foreach(Do: ((i: Int, value: T?) -> Unit)) {
    if (this != null) {
        for ((count, thing) in this.withIndex()) {
            Do(count, thing)
        }
    }
}

inline fun <T, S> java.util.Dictionary<T?, S?>?.foreach(Do: ((i: Int, key: T?, value: S?) -> Unit)) {
    if (this != null) {
        var count = 0;
        for (key in this.keys()) {
            Do(count, key, this[key])
            count++
        }
    }
}