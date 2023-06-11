package com.example.calculatorapp.abstract

class Car(override var model: Int) : Vehicle() {
    //need to implement the abstract function and variable
    override fun vehicleName(name: String): String {
        TODO("Not yet implemented")
    }

}