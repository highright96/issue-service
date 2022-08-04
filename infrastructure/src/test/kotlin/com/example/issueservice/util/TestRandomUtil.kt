package com.example.issueservice.util

import java.util.*
import kotlin.random.Random

fun genInt(): Int = Random.nextInt()

fun genLong(): Long = Random.nextLong()

fun genString(length: Int = 4) =
    UUID.randomUUID().toString().let { str ->
        str.substring(0, if (length > str.length) str.length else length)
    }