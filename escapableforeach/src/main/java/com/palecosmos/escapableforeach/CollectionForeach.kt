package com.palecosmos.escapableforeach

inline fun <T> List<T>?.escapableForEach(Do: (index: Int, value: T?) -> Boolean) {
    if (this != null)
        loop@ for (st in 0 until size) {
            if (!Do(st, this[st])) break@loop
        }
}

inline fun <T> List<T?>?.escapableForEachNullable(
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

inline fun <T> Set<T>?.escapableForEach(Do: (index: Int, value: T?) -> Boolean) {
    var count = 0
    if (this != null)
        loop@ for (thing in this) {
            if (!Do(count, thing)) break@loop
            count++
        }
}

inline fun <T> Set<T?>?.escapableForEachNullable(
    NotNull: (index: Int, value: T) -> Boolean,
    IsNull: (index: Int) -> Boolean = { _ -> true }
) {
    var count = 0
    if (this != null)
        loop@ for (thing: T? in this) {
            if (thing != null) {
                if (!NotNull(count, thing)) break@loop
            } else {
                if (!IsNull(count)) break@loop
            }
            count++
        }
}

inline fun <T, S> Map<T, S?>?.escapableForEach(Do: (index: Int, key: T, value: S?) -> Boolean) {
    var count = 0
    if (this != null)
        loop@ for (thing in this) {
            if (!Do(count, thing.key, thing.value)) break@loop
            count++
        }
}

inline fun <T, S> Map<T, S?>?.escapableForEachNullable(
    NotNull: (index: Int, key: T, value: S) -> Boolean,
    IsNull: (index: Int, key: T) -> Boolean = { _, _ -> true }
) {
    var count = 0
    if (this != null)
        loop@ for (thing in this) {
            if (thing.value != null) {
                if (!NotNull(count, thing.key, thing.value!!)) break@loop
            } else {
                if (!IsNull(count, thing.key)) break@loop
            }
            count++
        }
}