package com.example.mymovieapp

import androidx.lifecycle.MutableLiveData
import com.example.mymovieapp.DTO.Resource
import com.example.mymovieapp.Model.Movie
import com.example.mymovieapp.viewModel.MovieViewModel
import org.junit.Test


class MainActivityTest {

    @org.junit.jupiter.api.AfterEach
    fun tearDown() {
    }


   /* @Test
    fun testSuccessfulApiCall() {
        // Mock the ViewModel and observe the movieResponse LiveData
        val viewModel = mock<MovieViewModel> {
            on { movieResponse } doReturn MutableLiveData(Resource.success(listOf(Movie(...))))
        }

        // Launch the activity
        val scenario = launchActivity<MainActivity>()

        // Verify that the RecyclerView is displayed with data
        onView(withId(R.id.recyclerview)).check(matches(isDisplayed()))
        onView(withText("Movie Title")).check(matches(isDisplayed())) // Assuming movie title is displayed in the RecyclerView item
    }*/

}