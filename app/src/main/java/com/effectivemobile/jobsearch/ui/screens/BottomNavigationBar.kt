package com.effectivemobile.jobsearch.ui.screens

import androidx.compose.foundation.background
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.effectivemobile.jobsearch.R

data class BottomNavItem(
    val route: String,
    val selectedIcon: Int,
    /*val unselectedIcon: Int,*/
    val label: Int,
    val badgeCount: Int = 0
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavBar(
    navController: NavController
){
    val items = listOf(
        BottomNavItem("search", R.drawable.search_unselected, R.string.search),
        BottomNavItem("favorites", R.drawable.favorite_unselected, R.string.favorites, 1),
        BottomNavItem("responses", R.drawable.resposes, R.string.responses),
        BottomNavItem("messages", R.drawable.mesagepng, R.string.messages),
        BottomNavItem("profile", R.drawable.profile, R.string.profile)
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = Color.LightGray
    ) {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    BadgedBox(
                        badge = {
                            if (item.badgeCount > 0) {
                                Badge {
                                    Text(
                                        item.badgeCount.toString(),
                                        modifier = Modifier
                                            .background(MaterialTheme.colorScheme.onBackground)
                                    )
                                }
                            }
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = item.selectedIcon),
                            contentDescription = stringResource(id = item.label)
                        )
                    }
                },
                label = {
                    Text(
                        stringResource(id = item.label),
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Light
                    ) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.tertiary,
                    unselectedIconColor = Color.LightGray,
                    selectedTextColor = MaterialTheme.colorScheme.tertiary,
                    unselectedTextColor = Color.LightGray,
                    indicatorColor = MaterialTheme.colorScheme.background
                )
            )
        }
    }
}
