package com.github.chuross.trancebaka.ui.fragment.screen.base


interface Screen {

    val isRoot: Boolean
    val parent: Screen?
    //TODO 遷移アニメーションの指定
}