package com.example.moviesapp.screens.home

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.moviesapp.model.getMovies
import com.example.moviesapp.navigation.MovieScreens
import com.example.moviesapp.widgets.MovieRow


@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Transparent, elevation = 0.dp, modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(text = "Movies", style = TextStyle(textAlign = TextAlign.Center, fontWeight = FontWeight.ExtraBold, fontSize = 30.sp))
            }
        }
    }) {
        MainContent(navController = navController)

    }
}

@Composable
fun MainContent(navController: NavController, movieList: List<com.example.moviesapp.model.Movie> = getMovies()) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn{
            items(items = movieList) {
                MovieRow(movie = it){ movie ->
                    // Navigate to details page
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")
                    Log.d("TAG", "MainContent: $movie")

                }
            }
        }
    }
}
