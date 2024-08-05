package com.enoca.tmdb.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.enoca.tmdb.data.model.TmdbConfiguration
import com.enoca.tmdb.network.model.MovieDto

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
){
    val nowplaying = viewModel.nowplaying.collectAsLazyPagingItems()
    Scaffold(
        topBar = {

        },
        bottomBar = {

        }
    ){
        Column(
            modifier = Modifier.padding(it)
        ){
            LazyRow(
                modifier = Modifier.padding(8.dp)
                    .fillMaxWidth()
                    .height(200.dp)
            ){
                items(nowplaying.itemCount){
                    NowPlayingItem(nowplaying[it])
                }
            }
        }
    }
}

@Composable
fun NowPlayingItem(movieDto: MovieDto?) {
    Card {
        AsyncImage(model ="${TmdbConfiguration.IMAGE_BASE_URL}${movieDto?.posterPath}", contentDescription = "movie poster")
    }
}
