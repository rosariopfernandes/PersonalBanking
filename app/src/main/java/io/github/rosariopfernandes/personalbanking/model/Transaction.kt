package io.github.rosariopfernandes.personalbanking.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by rosariopfernandes on 3/20/18.
 */
@Entity
data class Transaction(@PrimaryKey(autoGenerate = true) var id:Int, var date:String, var description:String, var category:Int,
                       var source:Int, var amount:Double){
    constructor():this(0, "", "", 0, 0, 0.0)
}