package com.calyr.framework.local

import android.content.Context
import com.calyr.data.ILocalDataSource
import com.calyr.data.NetworkResult
import com.calyr.domain.Movie
import com.calyr.framework.toMovie
import com.calyr.framework.toMovieEntity

class LocalDataSource( val context: Context): ILocalDataSource {

    val dao: IMovieDao = AppRoomDatabase.getDatabase(context).movieDao()
    override fun getList(): NetworkResult<List<Movie>> {

        return NetworkResult.Success(
            dao.getList().map {
                it.toMovie()
            }
        )
    }

    override suspend fun deleteAll() {
        dao.deleteAll()
    }

    override fun insertMovies(list: List<Movie>) {
        val moviesEntity = list.map { it.toMovieEntity() }
        dao.insertMovies(moviesEntity)
    }

    override fun findById(id: String): NetworkResult<Movie> {
        val movieDb = dao.findById(id)
        if(movieDb!==null) {
            return NetworkResult.Success( movieDb.toMovie() )
        } else {
            return NetworkResult.Error("Id not found")
        }
    }
}