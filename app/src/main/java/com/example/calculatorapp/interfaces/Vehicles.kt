package com.example.calculatorapp.interfaces

class Vehicles :CanGo,CanStop {
    override val name: String
        get() = "Ferrari"

    override fun stop() {
        println("Vehicles can stop")
    }
}