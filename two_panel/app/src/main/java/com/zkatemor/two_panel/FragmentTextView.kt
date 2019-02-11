package com.zkatemor.two_panel

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_textview.*
import java.util.*

class FragmentTextView : Fragment() {

    private var count: String = "Amount: 0"

    companion object {

        fun newInstance(): FragmentTextView {
            return FragmentTextView()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        when
        {
            (arguments == null) -> count = "Amount: 0" else -> count = arguments!!.getString("count")
        }
        return inflater.inflate(R.layout.fragment_textview, container, false)
    }

    override fun onStart() {
        super.onStart()
        textView.text = "Amount: " + count

        val rnd = Random()
        val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        frame.setBackgroundColor(color)
    }

}