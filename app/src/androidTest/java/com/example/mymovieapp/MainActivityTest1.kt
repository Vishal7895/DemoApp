package com.example.mymovieapp

import androidx.lifecycle.MutableLiveData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.core.internal.deps.guava.base.Joiner.on
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import com.example.mymovieapp.DTO.Resource
import com.example.mymovieapp.Model.Movie
import com.example.mymovieapp.Repository.MovieRepository
import com.example.mymovieapp.viewModel.MovieViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner
import java.util.regex.Pattern.matches

@RunWith(MockitoJUnitRunner::class)
class MainActivityTest1{
    lateinit var viewModel: MovieViewModel
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(ProfileActivity::class.java)


    @Before
    fun setUp(){
        viewModel=Mockito.mock(MovieViewModel::class.java)
    }

    @Test
    fun testSuccessfulApiCall() {


        onView(withId(R.id.recyclerview)).check(ViewAssertions.matches(isDisplayed()))

        onView(withText("Movie Title")).check(ViewAssertions.matches(isDisplayed())) // Assuming movie title is displayed in the RecyclerView item
    }

}