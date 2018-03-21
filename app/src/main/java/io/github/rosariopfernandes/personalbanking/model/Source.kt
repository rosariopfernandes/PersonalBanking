package io.github.rosariopfernandes.personalbanking.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by rosariopfernandes on 3/20/18.
 */
@Entity
data class Source(@PrimaryKey(autoGenerate = true) var id:Int, var name:String,
                  var balance:Double){
    constructor():this(0,"",0.0)
}