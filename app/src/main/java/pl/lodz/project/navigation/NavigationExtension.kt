package pl.lodz.project.navigation

import android.app.Activity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import pl.lodz.project.R

fun Activity.getNavigator(): Navigation {
    val navController = findNavController(R.id.navHostFragment)
    return Navigator(navController)
}

fun Activity.getNavController(): NavController =
    findNavController(R.id.navHostFragment)