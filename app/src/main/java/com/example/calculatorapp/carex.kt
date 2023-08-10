package com.example.calculatorapp

abstract class carex {
    abstract fun getBrand() //mandatory to override it

    fun getNumberOfWheels():Int{
        return 4
    }//we can make this fn open if we still want it to be overridden
}