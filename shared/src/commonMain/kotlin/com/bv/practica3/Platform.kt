package com.bv.practica3

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform