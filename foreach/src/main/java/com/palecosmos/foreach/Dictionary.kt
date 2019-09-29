package com.palecosmos.foreach

import java.lang.Exception
import java.util.*

class Dictionary<K, V> {

    private var keys: Vector<K>
    private var values: Vector<V>

    constructor() {
        keys = Vector()
        values = Vector()
    }

    private constructor(mKeys: Vector<K>, mValues: Vector<V>) {
        keys = mKeys
        values = mValues
    }


    fun clear() {
        keys.clear()
        values.clear()
    }

    fun copy() = Dictionary(keys, values)

    fun deepCopy() = Dictionary<K, V>().apply {
        this@Dictionary.foreach { key: K, value: V ->
            put(key, value)
        }
    }

    fun put(key: K, value: V) =
        try {
            if (keys.contains(key)) {
                false
            } else {
                keys.add(key)
                values.add(value)
                true
            }
        } catch (e: Exception) {
            false
        }


    fun add(pair: Pair<K, V>) =
        try {
            if (keys.contains(pair.first)) {
                false
            } else {
                keys.add(pair.first)
                values.add(pair.second)
                true
            }
        } catch (e: Exception) {
            false
        }

    fun isEmpty() = keys.size == 0

    fun remove(key: K?) = try {
        if (keys.contains(key)) {
            val index = keys.indexOf(key)
            keys.removeElementAt(index)
            values.removeElementAt(index)
            true
        } else {
            false
        }
    } catch (e: Exception) {
        false
    }

    fun get(key: K?): V? = try {
        if (keys.contains(key)) {
            val index = keys.indexOf(key)
            values[index]
        } else {
            null
        }
    } catch (e: Exception) {
        null
    }

    fun size() = keys.size

    fun elements(): Enumeration<V> = values.elements()

    fun keys(): Enumeration<K> = keys.elements()

    operator fun iterator(): Iterator<Pair<K, V>> = object : Iterator<Pair<K, V>> {
        var current = 0
        override fun hasNext(): Boolean {
            return current < size() - 1
        }

        override fun next(): Pair<K, V> {
            current += 1
            return Pair(keys[current], values[current])
        }
    }

    fun foreach(Do: (i: Int, key: K, value: V) -> Unit?) {
        for (num in 0 until keys.size) {
            Do(num, keys[num], values[num])
        }
    }

    fun foreach(Do: (i: Int) -> Unit) {
        for (num in 0 until keys.size) {
            Do(num)
        }
    }

    fun foreach(Do: (key: K, value: V) -> Unit) {
        for (num in 0 until keys.size) {
            Do(keys[num], values[num])
        }
    }

    operator fun plus(another: Dictionary<K, V>) =
        try {
            another.foreach { K, V ->
                this.keys.add(K)
                this.values.add(V)
            }
            true
        } catch (e: Exception) {
            false
        }

    operator fun minus(another: Dictionary<K, V>) =
        try {
            var flag = false
            another.foreach { K, V ->
                if (keys.contains(K)) {
                    keys.remove(K)
                    values.remove(V)
                    flag = true
                }
            }
            flag
        } catch (e: Exception) {
            false
        }

    fun setValue(key: K, value: V) = try {
        var flag = false
        foreach { i, k, _ ->
            if (k == key) {
                flag = true
                values[i] = value
            }
        }
        flag
    } catch (e: Exception) {
        false
    }
}



