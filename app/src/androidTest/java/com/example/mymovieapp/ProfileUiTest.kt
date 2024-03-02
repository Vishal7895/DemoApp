package com.example.mymovieapp


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Rule
import org.junit.Test

@LargeTest
class ProfileUiTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(ProfileActivity::class.java)

    @Test
    fun testProfilePictureDisplayed() {
        // Check if profile picture is displayed
        onView(withId(R.id.profile_picture)).check(matches(isDisplayed()))
    }

    @Test
    fun testUserNameDisplayed() {
        // Check if user name is displayed and has correct text
        onView(withId(R.id.user_name)).check(matches(isDisplayed()))
        onView(withId(R.id.user_name)).check(matches(withText("Vishal Garg")))
    }

    @Test
    fun testEducationDetailsDisplayed() {
        // Check if education details are displayed correctly
        onView(withId(R.id.education_title)).check(matches(isDisplayed()))
        onView(withId(R.id.education_degree)).check(matches(isDisplayed()))
        onView(withId(R.id.education_university)).check(matches(isDisplayed()))
        onView(withId(R.id.education_years)).check(matches(isDisplayed()))

        // Optionally, you can also check the text of each TextView
        onView(withId(R.id.education_degree)).check(matches(withText("Degree: Bachelor of Science")))
        onView(withId(R.id.education_university)).check(matches(withText("University: Example University")))
        onView(withId(R.id.education_years)).check(matches(withText("Year: 2015-2019")))
    }

    // Write similar tests for other TextViews and CardViews
}
