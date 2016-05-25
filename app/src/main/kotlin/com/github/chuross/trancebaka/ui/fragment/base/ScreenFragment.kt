package com.github.chuross.trancebaka.ui.fragment.base

import android.support.v4.app.Fragment

interface ScreenFragment {

    val self: Fragment
    val screen: Screen
    val identity: String
}