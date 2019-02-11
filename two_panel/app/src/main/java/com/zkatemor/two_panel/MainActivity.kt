package com.zkatemor.two_panel

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_textview.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.root_layout, FragmentButton.newInstance())
                .commit()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        count--

        if (count == 0) {
            var layoutParams = LinearLayout.LayoutParams(Toolbar.LayoutParams.MATCH_PARENT, 0, 0f)
            second_layout.layoutParams = layoutParams
        }
    }

    fun addFragment(view: View?) {
        count++

        var layoutParams = LinearLayout.LayoutParams(Toolbar.LayoutParams.MATCH_PARENT, 0, 1.0f)
        second_layout.layoutParams = layoutParams

        var bundle = Bundle()
        bundle.putString("count", count.toString())

        var fragment = FragmentTextView()
        fragment.arguments = bundle

        var transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.second_layout, fragment).addToBackStack(null).commit()
    }
}