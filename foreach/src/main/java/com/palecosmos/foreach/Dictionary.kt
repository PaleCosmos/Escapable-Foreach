package com.palecosmos.foreach

import java.lang.Exception
import java.util.*

class Dictionary<K, V> {

    private val keys = Vector<K>()
    private val values = Vector<V>()

    operator fun iterator(): Vector<Pair<K, V>> = Vector<Pair<K, V>>().apply {
        for (num in 0 until keys.size) {
            add(Pair(keys[num], values[num]))
        }


    }
    operator fun <E> Vector<E>.hasNext(): Boolean {
        return true
    }

    operator fun Vector<Pair<K, V>>.next():Pair<K,V>{
        return Pair(1 as K, 2 as V)
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

}