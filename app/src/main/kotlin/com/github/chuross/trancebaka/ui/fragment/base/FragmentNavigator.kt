package com.github.chuross.trancebaka.ui.fragment.base

import android.support.v4.app.FragmentManager


class FragmentNavigator(private val manager: FragmentManager, private val containerId: Int) {

    fun launchScreen(fragment: ScreenFragment) {
        when {
            manager.findFragmentById(containerId) == null -> {
                if (!fragment.screen.isRoot) throw IllegalArgumentException("not root screen")
                launchRootScreen(manager, fragment)
            }
            else ->
                launchChildScreen(manager, fragment)
        }
    }

    private fun launchRootScreen(manager: FragmentManager, fragment: ScreenFragment) {
        manager.beginTransaction().apply {
            replace(containerId, fragment.self, fragment.identity)
        }.commit()
        manager.executePendingTransactions()
    }

    private fun launchChildScreen(manager: FragmentManager, fragment: ScreenFragment) {
        if (currentScreenFragment()?.identity.equals(fragment.identity)) {
            return
        }

        manager.beginTransaction().apply {
            add(containerId, fragment.self, fragment.identity)
            addToBackStack(fragment.screen.toString())
        }.commit()
        manager.executePendingTransactions()
    }

    fun popBackStack(): Boolean {
        return when {
            manager.backStackEntryCount > 0 ->
                manager.popBackStackImmediate()
            else ->
                false
        }
    }

    fun homeAsUp() {
        currentScreenFragment()?.let {
            it.screen.parent?.let { parent ->
                when {
                    parent.isRoot -> manager.popBackStackImmediate(manager.getBackStackEntryAt(0).id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
                    else -> manager.popBackStackImmediate(parent.toString(), 0)
                }
            } ?: manager.popBackStackImmediate()
        }
    }

    private fun currentScreenFragment(): ScreenFragment? {
        val fragment = manager.findFragmentById(containerId)
        if (fragment == null || fragment !is ScreenFragment) throw IllegalStateException("not implemented ScreenFragment.")
        return fragment
    }
}