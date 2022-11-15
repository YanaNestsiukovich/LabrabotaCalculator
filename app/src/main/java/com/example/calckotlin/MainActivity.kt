package com.example.calckotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var enterNumView:TextView? = null
    var firstNumView:TextView? = null
    var secondNumView:TextView? = null
    var operationView:TextView? = null
    var answerView:TextView? = null
    var numFirst:Button? = null
    var numSecond:Button? = null
    var numThird:Button? = null
    var numFour:Button? = null
    var numFive:Button? = null
    var numSix:Button? = null
    var numSeven:Button? = null
    var numEight:Button? = null
    var numNine:Button? = null
    var numZero:Button? = null
    var delNum:Button? = null
    var deleteAll:Button? = null
    var dot:Boolean = false
    var firstNumber:Double = 0.0
    var secondNumber:Double = 0.0

    lateinit var  str:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        str = ""
        setContentView(R.layout.activity_main)
        enterNumView = findViewById(R.id.enterNumView)
        firstNumView = findViewById(R.id.firstNumView)
        secondNumView = findViewById(R.id.secondNumView)
        operationView = findViewById(R.id.operationView)
        answerView = findViewById(R.id.answerView)
        numFirst = findViewById(R.id.numFirst)
        numSecond = findViewById(R.id.numSecond)
        numThird = findViewById(R.id.numThird)
        numFour = findViewById(R.id.numFour)
        numFive = findViewById(R.id.numFive)
        numSix = findViewById(R.id.numSix)
        numSeven = findViewById(R.id.numSeven)
        numEight = findViewById(R.id.numEight)
        numNine = findViewById(R.id.numNine)
        numZero = findViewById(R.id.numZero)
        deleteAll = findViewById(R.id.deleteAll)
        delNum = findViewById(R.id.delNum)
    }
    fun numFirstAction(v: View){
        deleteZeroBeforeTheNumber()
        str += "1"
        enterNumView?.setText(str)
    }

    private fun deleteZeroBeforeTheNumber() {
        if(str.length>0 && str.get(0) != '0') {
            var indexOfZero: Int = (str.length) - 1

            if (str.get(indexOfZero) == '0' && !dot) {
                str = str.substring(0, indexOfZero)
            }
        }
    }

    fun numSecondAction(v:View){
        deleteZeroBeforeTheNumber()
        str += "2"
        enterNumView?.setText(str)
    }
    fun numThirdAction(v:View){
        deleteZeroBeforeTheNumber()
        str += "3"
        enterNumView?.setText(str)
    }
    fun numFourAction(v:View){
        deleteZeroBeforeTheNumber()
        str += "4"
        enterNumView?.setText(str)
    }
    fun numFiveAction(v:View){
        deleteZeroBeforeTheNumber()
        str += "5"
        enterNumView?.setText(str)
    }
    fun numSixAction(v:View){
        deleteZeroBeforeTheNumber()
        str += "6"
        enterNumView?.setText(str)
    }
    fun numSevenAction(v:View){
        deleteZeroBeforeTheNumber()
        str += "7"
        enterNumView?.setText(str)
    }
    fun numEightAction(v:View){
        deleteZeroBeforeTheNumber()
        str += "8"
        enterNumView?.setText(str)
    }
    fun numNineAction(v:View){
        deleteZeroBeforeTheNumber()
        str += "9"
        enterNumView?.setText(str)
    }
    fun numZeroAction(v:View){
        deleteZeroBeforeTheNumber()
        str += "0"
        enterNumView?.setText(str)
    }
    fun addDeleteAction(v:View){
        operationView?.setText("/")
    }
    fun addPlusAction(v:View){
        operationView?.setText("+")
    }
    fun addMinusActionOperation(v:View){
        operationView?.setText("-")
    }
    fun addMultiplyAction(v:View){
        operationView?.setText("*")
    }
    fun delNumAction(v: View){
        dotDelete()
        if(str.length > 0){
        str = str.substring(0,str.length - 1)
        enterNumView?.setText(str)
        }

    }

    private fun dotDelete() {
        if (str.substring(str.length - 1, str.length).equals(".")) {
            dot = false
        }
    }

    fun deleteAllAction(v: View){
            if(dot == true) dot = false
            str = ""
            enterNumView?.setText(str)
    }
    fun addFirstAction(v: View){
        if(str.equals("")) firstNumView?.setText("0")
        else if(str.equals("-"))firstNumView?.setText("-1")
        else if(str.substring(str.length- 1, str.length).equals("."))firstNumView?.setText(str + 0)
        else {firstNumView?.setText(str)}
        //enterNumView?.setText(str)
    }
    fun addSecondAction(v: View){
        if(str.equals("")) secondNumView?.setText("0")
        else if(str.equals("-"))secondNumView?.setText("-1")
        else if(str.substring(str.length- 1, str.length).equals(".")) secondNumView?.setText(str + 0)
        else {secondNumView?.setText(str)}
        //enterNumView?.setText(str)
    }
    fun addSignOrAction(v: View){
        operationView?.setText("|")
    }
    fun addSignAndAction(v: View){
        operationView?.setText("&")
    }
    fun addSignTildAction(v: View){
        val duration = Toast.LENGTH_LONG
        val toast = Toast.makeText(applicationContext, R.string.forTilda, duration)
        toast.show()
        operationView?.setText("~")
    }
    fun addSignToLeftAction(v: View){
        val duration = Toast.LENGTH_LONG
        val toast = Toast.makeText(applicationContext, R.string.forShl, duration)
        toast.show()
        operationView?.setText("<<")
    }
    fun addMinusAction(v: View){
        if(str.length == 0) str+= "-"
        enterNumView?.setText(str)
    }
    fun addDotAction(v: View){
        if(dot == false && str.length>0 && str.substring(str.length-1, str.length)!="-") {
            str+= "."
            dot = true
        }
        enterNumView?.setText(str)
    }
    @SuppressLint("SuspiciousIndentation")
    fun giveAnswerAction(v:View){
        if(firstNumView?.text.toString() == "" || secondNumView?.text.toString() == ""){
            answerView?.text = getString(R.string.invalidData)
        }
        val operation:String = operationView?.text.toString()
        if(operation == "+" || operation == "-" || operation == "*" || operation == "/"){
        firstNumView?.let { adaDotAndZero(it) }
        secondNumView?.let { adaDotAndZero(it) }
        firstNumber = firstNumView?.text.toString().toDouble()
        secondNumber = secondNumView?.text.toString().toDouble()

        var answerString:String = (when(operation){
            "+" -> (firstNumber + secondNumber).toString()
            "-" -> (firstNumber - secondNumber).toString()
            "*" -> (firstNumber * secondNumber).toString()
            "/" -> (if(secondNumber == 0.0){"Error"}
                else{(firstNumber / secondNumber).toString()})
            else -> "Error"
        })
            answerView?.setText(answerString)
        }else{
            var stringToDel:String = ""
            stringToDel = firstNumView?.let { returnWithoutDot(it) }.toString()
            var firstNumberInt = stringToDel.toInt()
            stringToDel = secondNumView?.let { returnWithoutDot(it) }.toString()
            var secondNumberInt = stringToDel.toInt()

            var answerString:String =  (when(operation){
                "|" -> (firstNumberInt or secondNumberInt).toString()
                "&" -> (firstNumberInt and secondNumberInt).toString()
                "~" -> (firstNumberInt.inv()).toString()
                "<<" -> (firstNumberInt shl secondNumberInt).toString()
                else -> {"Error"}})
            answerView?.text = answerString
        }
    }

    private fun returnWithoutDot(firstNumView:TextView): String {
        if (firstNumView?.text.toString().contains('.')) {
            var indexDot = firstNumView?.text.toString().indexOf('.')
            var answer: String = firstNumView?.text.toString().substring(0, indexDot)
            return answer
        }
        else{
            return firstNumView?.text.toString()
        }
    }


    private fun adaDotAndZero(secondNumView:TextView) {
        if (!secondNumView?.text.toString().contains(".", ignoreCase = true)) {
            secondNumView?.setText(secondNumView?.text.toString() + ".0")
        }
    }
}
//убрать 0 перед цифрой, альбомная ориентация, локализация, изменить вет кнопок