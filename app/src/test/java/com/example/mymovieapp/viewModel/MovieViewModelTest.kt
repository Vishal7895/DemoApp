package com.example.mymovieapp.viewModel

import com.example.mymovieapp.DTO.Resource
import com.example.mymovieapp.Model.Movie
import com.example.mymovieapp.Repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MovieViewModelTest {
    private val testDispatcher= StandardTestDispatcher()
    @Mock
    lateinit var repository: MovieRepository

    @OptIn(ExperimentalCoroutinesApi::class)
    @BeforeEach
    fun setUp() {

        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun getList()= runTest {
        Mockito.`when`(repository.getPopularMovie()).thenReturn(flow { emptyList<Movie>() })
        val sut = MovieViewModel(repository)

        sut.getPopularMovie("")
        testDispatcher.scheduler.advanceUntilIdle()
        val result= sut.movieResponse.value
        if (result != null) {
            Assert.assertEquals(0, result.data?.size)
        }

    }
    @OptIn(ExperimentalCoroutinesApi::class)
    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
    }
}