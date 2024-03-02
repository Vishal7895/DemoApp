package com.example.mymovieapp.Repository

import com.example.mymovieapp.DB.movieDb
import com.example.mymovieapp.Model.Movie
import com.example.mymovieapp.Model.MovieResponse
import com.example.mymovieapp.Remote.RestApi
import com.example.mymovieapp.viewModel.MovieViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MovieRepositoryTest {
    private val testDispatcher= StandardTestDispatcher()
    @Mock
    lateinit var api: RestApi
    @Mock
    lateinit var movieDb: movieDb

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun getList()= runTest {
        Mockito.`when`(api.getPopularMovies("","")).thenReturn(MovieResponse(results = emptyList()))
        val sut = MovieRepository(api,movieDb)

        sut.getPopularMovie("")
        testDispatcher.scheduler.advanceUntilIdle()
        val result= sut.getPopularMovie()
        assertEquals(0, result.collect{
    it!!.size
})

    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
    }
}