package com.calyr.data

import com.calyr.domain.Movie

interface IRemoteDataSource {
    suspend fun fetchData(): NetworkResult<List<Movie>>
}