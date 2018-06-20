package com.cogitator.mvpvsmvvm_android.presentation

import android.support.v7.app.AppCompatActivity
import android.content.Intent
import android.view.View
import com.cogitator.mvpvsmvvm_android.R
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*


/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 20/06/2018 (MM/DD/YYYY)
 */
class MainActivity : AppCompatActivity() {
    private val clickListener = View.OnClickListener { v ->
        when (v.id) {
            R.id.btn_MVP -> {
                val mvpIntent = Intent(this@MainActivity, NavigationActivity::class.java)
                startActivity(mvpIntent)
            }
            R.id.btn_MVVM -> {
                val mvvmIntent = Intent(this@MainActivity, MainNavigatorViewModelImpl::class.java)
                startActivity(mvvmIntent)
            }
            else -> {
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_MVP.setOnClickListener(clickListener)
        btn_MVVM.setOnClickListener(clickListener)
    }
}