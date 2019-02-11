package com.zkatemor.two_panel

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class FragmentButton : Fragment() {

    companion object {

        fun newInstance(): FragmentButton {
            return FragmentButton()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_button, container, false)
    }

}