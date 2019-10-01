package com.palecosmos.escapableforeach

inline fun <T> Array<out T?>?.escapableForEach(Do: (index: Int, value: T?) -> Boolean) {
    if (this != null)
        loop@ for (st in 0 until size) {
            if (!Do(st, this[st])) break@loop
        }
}

inline fun <T> Array<out T?>?.escapableForEachNullable(
    NotNull: (index: Int, value: T) -> Boolean,
    IsNull: (index: Int) -> Boolean = { _ -> true }
) {
    if (this != null)
        loop@ for (st in 0 until size) {
            if (this[st] != null) {
                if (!NotNull(st, this[st]!!)) break@loop
            } else {
                if (!IsNull(st)) break@loop
            }
        }
}

inline fun ByteArray?.escapableForEach(Do: (index: Int, value: Byte) -> Boolean) {
    if (this != null)
        loop@ for (st in 0 until size) {
            if (!Do(st, this[st])) break@loop
        }
}

inline fun ShortArray?.escapableEscapableForEach(Do: (index: Int, value: Short) -> Boolean) {
    if (this != null)
        loop@ for (st in 0 until size) {
            if (!Do(st, this[st])) break@loop
        }
}

inline fun IntArray?.escapableForEach(Do: (index: Int, value: Int) -> Boolean) {
    if (this != null)
        loop@ for (st in 0 until size) {
            if (!Do(st, this[st])) break@loop
        }
}

inline fun LongArray?.escapableForEach(Do: (index: Int, value: Long) -> Boolean) {
    if (this != null)
        loop@ for (st in 0 until size) {
            if (!Do(st, this[st])) break@loop
        }
}

inline fun FloatArray?.escapableForEach(Do: (index: Int, value: Float) -> Boolean) {
    if (this != null)
        loop@ for (st in 0 until size) {
            if (!Do(st, this[st])) break@loop
        }
}

inline fun DoubleArray?.escapableForEach(Do: (index: Int, value: Double) -> Boolean) {
    if (this != null)
        loop@ for (st in 0 until size) {
            if (!Do(st, this[st])) break@loop
        }
}

inline fun BooleanArray?.escapableForEach(Do: (index: Int, value: Boolean) -> Boolean) {
    if (this != null)
        loop@ for (st in 0 until size) {
            if (!Do(st, this[st])) break@loop
        }
}

inline fun CharArray?.escapableForEach(Do: (index: Int, value: Char) -> Boolean) {
    if (this != null)
        loop@ for (st in 0 until size) {
            if (!Do(st, this[st])) break@loop
        }
}