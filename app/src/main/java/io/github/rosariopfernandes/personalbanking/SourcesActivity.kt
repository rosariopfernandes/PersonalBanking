package io.github.rosariopfernandes.personalbanking

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.text.InputType
import io.github.rosariopfernandes.personalbanking.adapter.SourcesAdapter
import io.github.rosariopfernandes.personalbanking.model.Category
import io.github.rosariopfernandes.personalbanking.model.Source
import io.github.rosariopfernandes.personalbanking.util.BankingDatabase
import io.github.rosariopfernandes.personalbanking.viewmodel.SourcesViewModel

import kotlinx.android.synthetic.main.activity_categories.*
import kotlinx.android.synthetic.main.content_categories.*
import org.jetbrains.anko.*

class SourcesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        fab.setOnClickListener { view ->
            alert {
                title = getString(R.string.new_source)
                customView {
                    verticalLayout {
                        val sourceNameEditText = editText {
                            inputType = InputType.TYPE_TEXT_VARIATION_PERSON_NAME
                            hint = getString(R.string.hint_source_name)
                        }.lparams(width = matchParent) {
                            margin = dip(16)
                        }
                        val sourceBalanceEditText = editText {
                            inputType = InputType.TYPE_NUMBER_FLAG_DECIMAL
                            hint = getString(R.string.hint_current_balance)
                        }.lparams(width = matchParent) {
                            margin = dip(16)
                        }
                        negativeButton(R.string.action_cancel){

                        }
                        positiveButton(R.string.action_add) {
                            val database = BankingDatabase.getInstance(applicationContext)
                            doAsync{
                                database!!.sourceDao()
                                        .createSource(Source(null, sourceNameEditText.text.toString(),
                                                sourceBalanceEditText.text.toString().toDouble()))
                            }
                            runOnUiThread {
                                Snackbar.make(view, R.string.new_source_confirmation,
                                        Snackbar.LENGTH_SHORT).show()
                            }
                        }
                    }
                }
            }.show()
        }

        rvCategories.layoutManager = LinearLayoutManager(this)

        ViewModelProviders.of(this).get(SourcesViewModel::class.java)
                .sources?.observe(this, Observer { list ->
                    rvCategories.adapter = SourcesAdapter(list)
                })
    }

}
