package com.example.calculatorapp.interfaces

fun main(args:Array<String>){
    var vehicles=Vehicles()
    println("Name: ${vehicles.name}")
    vehicles.go()
    vehicles.stop()
}