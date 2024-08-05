package com.enoca.tmdb.data.repository

import com.enoca.tmdb.network.TmdbNetworkDataSource
import com.enoca.tmdb.network.model.UserDataDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class UserDataRepository @Inject constructor(private val api: TmdbNetworkDataSource) {
    val userData: Flow<UserDataDto> = flow {
        emit(api.getUserData())
    }
        .catch {
            emit(
                UserDataDto(
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null
                )
            )
        }
        .flowOn(Dispatchers.IO)


}