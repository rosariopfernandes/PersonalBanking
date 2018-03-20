package io.github.rosariopfernandes.personalbanking.model

/**
 * Created by rosariopfernandes on 3/20/18.
 */
data class Transaction(var id:Int, var date:String, var description:String, var category:Int,
                       var source:Int, var amount:Double)