package com.example.calculatorapp.interfaces

fun main(){
    val result=sum(5,4)
    val s:(Int,Int)->Int=::sum   //reference of sum function.let in another class we want to call sum function.we can pass this ref and use the fn there.s has the ref of fn sum
    s(2,2) //calling the sum
    val sumLambda={a:Int,b:Int->
        println("Calculate sum")
        a+b
    }   //same as fn sum but through lambda
    val sumLambda2:(Int,Int)->Int={a,b->
        a+b

    }
    test(::sum)  //pass the sum function
    test(sumLambda) //pass the sumLambda fn

    val l= listOf<Int>(1,5,2,8,10)
    l.sorted() //sort the list l

    val fruits= listOf("Apple","Banana")
    fruits.sortedBy { it->
        it.length
    }    //sort the fruits list by length

    val fruitsPair = listOf<Pair<String, Int>>(Pair("Apple", 100), Pair("Banana", 50))

    fruitsPair.sortedBy {
        it.second
    }

    val map = mapOf("Apple" to 100, "Banana" to 50)

    for ((key, value) in map) {
        println("$key -> $value")
    }
    val answer=example()
    println(answer(true))

}
fun sum(a:Int,b:Int):Int{
    return a+b

}
fun test(calculate:(Int,Int)->Int):(Boolean)->String{
    val example={a:Boolean->
        println(a)
        "Hello"
    }
    val result:Int=calculate(2,5)
    return example
}
fun test1(calculate:(Int,Int)->Int):Int{
    return calculate(2,5)
}
fun example():(Boolean)->String{
    val answer={
        isCorrect:Boolean->
        if(isCorrect){
            "Correct"
        }
        else{
            "Incorrect"
        }
    }
    return answer
}
