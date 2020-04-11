package pl.lodz.project.navigation

import androidx.navigation.NavDirections

interface Navigation {
    fun navigate(destinanation: NavDirections)
    fun navigateBack(): Boolean
}