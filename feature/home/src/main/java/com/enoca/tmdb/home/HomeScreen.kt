package com.enoca.tmdb.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.enoca.tmdb.data.model.TmdbConfiguration
import com.enoca.tmdb.network.model.MovieDto

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
){
    val nowplaying = viewModel.nowplaying.collectAsLazyPagingItems()
    val popular = viewModel.popular.collectAsLazyPagingItems()
    val topRated = viewModel.topRated.collectAsLazyPagingItems()
    val upcoming = viewModel.upcoming.collectAsLazyPagingItems()
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            MovieList(items = nowplaying,"now playing")
            MovieList(items = popular, text = "popular")
            MovieList(items = topRated, text = "top rated")
            MovieList(items = upcoming, text = "upcoming")
        }

}

@Composable
fun MovieList(items: LazyPagingItems<MovieDto>,text:String){
    Column{
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = text)
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "show all")
                Icon(imageVector = Icons.Default.PlayArrow, contentDescription = "show all")
            }
        }
        LazyRow(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .height(190.dp),
        ){
            items(items.itemCount){
                NowPlayingItem(items[it])
            }
        }
    }
}


@Composable
fun NowPlayingItem(movieDto: MovieDto?) {
    Card(
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .fillMaxHeight()
    ) {
        SubcomposeAsyncImage(
            model = "${TmdbConfiguration.IMAGE_BASE_URL}${movieDto?.posterPath}",
            contentDescription = "movie poster",
            loading = {
                Box(
                    modifier = Modifier.fillMaxHeight()
                        .aspectRatio(0.67f)
                ){
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

            },
        )
//        AsyncImage(
//            model ="${TmdbConfiguration.IMAGE_BASE_URL}${movieDto?.posterPath}",
//            contentDescription = "movie poster",
//
//        )
    }
}
