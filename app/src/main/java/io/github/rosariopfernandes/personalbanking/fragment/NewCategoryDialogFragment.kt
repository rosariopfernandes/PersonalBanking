package io.github.rosariopfernandes.personalbanking.fragment

import android.app.Dialog
import android.app.DialogFragment
import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AlertDialog
import io.github.rosariopfernandes.personalbanking.R
import io.github.rosariopfernandes.personalbanking.util.BankingDatabase
import org.jetbrains.anko.doAsync

class NewCategoryDialogFragment() :DialogFragment()
{
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder =  AlertDialog.Builder(activity)
        builder.setTitle(R.string.new_category)
        builder.setNegativeButton(R.string.action_cancel, null)
        builder.setPositiveButton(R.string.action_continue,
                DialogInterface.OnClickListener { dialog, which ->
                    val database = BankingDatabase.getInstance(activity.applicationContext)
                    doAsync{

                    }
                })
        builder.setCancelable(false)
        return builder.create()
    }
}