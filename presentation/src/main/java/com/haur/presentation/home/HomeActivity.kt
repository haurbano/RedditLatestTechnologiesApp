package com.haur.presentation.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.haur.presentation.navigation.NavDestinations
import com.haur.presentation.postdetails.PostDetails
import com.haur.presentation.topposts.TopPostsScreen
import com.haur.presentation.topposts.TopPostsViewModel
import com.haur.presentation.ui.theme.DavigetTheme
import org.koin.android.ext.android.inject

@ExperimentalAnimationApi
@ExperimentalMaterialApi
class HomeActivity : ComponentActivity() {
    private val topPostsViewModel: TopPostsViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            DavigetTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = NavDestinations.TopPosts
                    )
                    {
                        composable(NavDestinations.TopPosts){
                            TopPostsScreen(viewModel = topPostsViewModel, navController = navController)
                        }
                        composable(
                            "${NavDestinations.PostDetails}/{post}",
                            arguments = listOf(navArgument("post"){
                            type = NavType.StringType
                        })){
                            val postText = it.arguments?.getString("post")
                            PostDetails(postText ?: "NO TEXT")
                        }
                    }
                }
            }
        }
    }
}