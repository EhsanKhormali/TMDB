package com.enoca.tmdb.nowplaying

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun NowPlayingScreen(viewModel: NowPlayingViewModel= hiltViewModel()) {
    val uiState=viewModel.uiState.collectAsState()
    Scaffold(
    ) {
        LazyColumn(
            modifier = Modifier.padding(it)
        ) {
            items(items = uiState.value.movies){
                Card {
                    Column {
                        Text(text = it.title.toString())

                    }
                }
            }
        }
    }
}