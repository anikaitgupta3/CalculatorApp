package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorActivity : AppCompatActivity() {

    lateinit var zero:TextView
    lateinit var one:TextView
    lateinit var two:TextView
    lateinit var three:TextView
    lateinit var four:TextView
    lateinit var five:TextView
    lateinit var six:TextView
    lateinit var seven:TextView
    lateinit var eight:TextView
    lateinit var nine:TextView

    //var zero1:TextView?=null

    lateinit var plus:TextView
    lateinit var minus:TextView
    lateinit var multiply:TextView
    lateinit var divide:TextView
    lateinit var modulo:TextView

    lateinit var changesign:TextView
    lateinit var decimals:TextView
    lateinit var equals:TextView
    lateinit var ac:TextView
    lateinit var back:ImageView

    lateinit var expression:TextView
    lateinit var result:TextView




    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        //zero?.text=

        /*if(this::zero.isInitialized){
            println(zero.text)
        }
        else{
            zero=
        }*/

        zero=findViewById(R.id.zero)
        one=findViewById(R.id.one)
        two=findViewById(R.id.two)
        three=findViewById(R.id.three)
        four=findViewById(R.id.four)
        five=findViewById(R.id.five)
        six=findViewById(R.id.six)
        seven=findViewById(R.id.seven)
        eight=findViewById(R.id.eight)
        nine=findViewById(R.id.nine)
        plus=findViewById(R.id.add)
        minus=findViewById(R.id.subtract)
        multiply=findViewById(R.id.multiply)
        divide=findViewById(R.id.divide)
        modulo=findViewById(R.id.modulo)

        changesign=findViewById(R.id.changesign)
        decimals=findViewById(R.id.decimal)
        equals=findViewById(R.id.equals)
        ac=findViewById(R.id.allclear)
        back=findViewById(R.id.back)
        expression=findViewById(R.id.expression)
        result=findViewById(R.id.result)

        appendtexthelper(zero,true)
        appendtexthelper(one,true)
        appendtexthelper(two,true)
        appendtexthelper(three,true)
        appendtexthelper(four,true)
        appendtexthelper(five,true)
        appendtexthelper(six,true)
        appendtexthelper(seven,true)
        appendtexthelper(eight,true)
        appendtexthelper(nine,true)
        appendtexthelper(plus,false)
        appendtexthelper(minus,false)
        appendtexthelper(multiply,false)
        appendtexthelper(divide,false)
        appendtexthelper(modulo,false)
        appendtexthelper(decimals,true)

        equals.setOnClickListener {
            try{
                 val expr=ExpressionBuilder(expression.text.toString()).build()
                val answer=expr.evaluate()
                result.text=answer.toString()
            }
            catch(exception:Exception){
               result.text=exception.message
            }
        }
        back.setOnClickListener {
            result.text=""
            result.hint=""

            if(expression.text.isNotEmpty()){
                expression.text.toString().substring(0..(expression.text.length-2))
            }
        }
        ac.setOnClickListener {
            result.text=""
            result.hint=""
            expression.text=""
        }
        changesign.setOnClickListener {
            result.text=""
            result.hint=""

            //-24->24
            //24->-24

            //Apple->substring(1,2)->p
            if(expression.text.isNotEmpty() && expression.text[0]=='-'){
                expression.text=expression.text.substring(1)
            }
            else{
                expression.text="-(${expression.text})"
            }
        }



        }

    private fun appendtexthelper(view: TextView,isnumberordecimal:Boolean){
        view.setOnClickListener {
            appendtext(view.text.toString(),isnumberordecimal)

        }
    } //private because used only in 1 class

    private fun appendtext(value:String,isnumberordecimal:Boolean){

        if(result.text!=""){
            expression.text=""
        }
        if(isnumberordecimal){
            //85+25 =110 press 2 result cleared expn will 2
            result.text=""
            if(expression.text.isNotEmpty() && expression.text.last()=='.' && value=="."){

            }
            else {
                //expression.text = "${expression.text}$value"
                expression.append(value)
            }
            //expression.append(value) (both are same)

        }else{
            //25 resultuser press * expn 25* result blank
            expression.append(result.text) //exp=25
            if(expression.text.isNotBlank() && (expression.text.last() in setOf('+','-','*',"/"))){
                expression.text=expression.text.dropLast(1) //remove last char
            }
            expression.append(value) //exp=25*
            result.text=""
        }
    result.hint=expression.text
    }
}