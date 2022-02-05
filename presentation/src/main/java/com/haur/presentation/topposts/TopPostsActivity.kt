package com.haur.presentation.topposts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.haur.presentation.ui.theme.DavigetTheme
import org.koin.android.ext.android.inject

class TopPostsActivity : ComponentActivity() {

    private val topPostsViewModel: TopPostsViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DavigetTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TopPostsScreen(topPostsViewModel)
                }
            }
        }
    }
}