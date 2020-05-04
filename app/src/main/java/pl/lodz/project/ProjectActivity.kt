package pl.lodz.project

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavDestination
import kotlinx.android.synthetic.main.project_activity.*
import pl.lodz.project.navigation.getNavController
import pl.lodz.project.navigation.getNavigator

class ProjectActivity: AppCompatActivity() {

    private val navigation by lazy {
        this.getNavigator()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.project_activity)

        setupBottomBar()
    }

    override fun onSupportNavigateUp(): Boolean = navigation.navigateBack()

    private fun setupBottomBar() {
        getNavController().addOnDestinationChangedListener{ _, destination, _ ->
            setComponentVisibilty(destination)
        }
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            item.isChecked = true
            val idFragment = when(item.itemId) {
                R.id.menuProfile -> R.id.profileFragment
                R.id.menuTask -> R.id.taskFragment
                R.id.menuPublications -> R.id.publicationsFragment
                R.id.menuTimeTable -> R.id.timeTableFragment
                else -> throw Exception("This Fragment doesn't exist")
            }
            getNavController().navigate(idFragment)
            false
        }
    }

    private fun setComponentVisibilty(destination: NavDestination) {
        if(destination.id == R.id.loginFragment) {
            bottomNavigation.visibility = View.GONE
        } else {
            bottomNavigation.visibility = View.VISIBLE
        }
    }
}