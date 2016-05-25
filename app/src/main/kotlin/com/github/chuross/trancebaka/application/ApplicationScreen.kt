package com.github.chuross.trancebaka.application

import com.github.chuross.trancebaka.ui.fragment.base.Screen


enum class ApplicationScreen : Screen {

    HOME {
        override val isRoot: Boolean = true
        override val parent: Screen? = null
    }

}