package io.github.rosariopfernandes.personalbanking

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.text.InputType
import io.github.rosariopfernandes.personalbanking.adapter.CategoriesAdapter
import io.github.rosariopfernandes.personalbanking.model.Category
import io.github.rosariopfernandes.personalbanking.util.BankingDatabase
import io.github.rosariopfernandes.personalbanking.viewmodel.CategoriesViewModel

import kotlinx.android.synthetic.main.activity_categories.*
import kotlinx.android.synthetic.main.content_categories.*
import org.jetbrains.anko.*

class CategoriesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            alert {
                title = getString(R.string.new_category)
                customView {
                    verticalLayout {
                        val amount = editText {
                            inputType = InputType.TYPE_TEXT_VARIATION_PERSON_NAME
                            hint = getString(R.string.hint_category_name)
                        }.lparams(width = matchParent) { margin = dip(16) }
                        negativeButton(R.string.action_cancel){

                        }
                        positiveButton(R.string.action_add) {
                            val database = BankingDatabase.getInstance(applicationContext)
                            doAsync{
                                database!!.categoryDao()
                                        .createCategory(Category(amount.text.toString()))
                            }
                            runOnUiThread {
                                Snackbar.make(view, R.string.new_category_confirmation,
                                        Snackbar.LENGTH_SHORT).show()
                            }
                        }
                    }
                }
            }.show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        rvCategories.layoutManager = LinearLayoutManager(this)

        ViewModelProviders.of(this).get(CategoriesViewModel::class.java)
                .tarefas?.observe(this, Observer { list ->
                    rvCategories.adapter = CategoriesAdapter(list)
                })
    }

}
