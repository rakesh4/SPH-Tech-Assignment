package com.example.sph.views

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.sph.R
import org.hamcrest.Matchers.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class MobileVolumeActivityTest{

    @get:Rule
    val activityRule = ActivityScenarioRule(MobileVolumeActivity::class.java)

    @Test
    fun test_activity_in_view() {
        val activityScenario = ActivityScenario.launch(MobileVolumeActivity::class.java)
        onView(withId(R.id.root_main)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isList_Visible_onAppLaunch() {
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))
    }

    @Test
    fun test_selectListItem() {
        onView(withId(R.id.recyclerView))
            .perform(actionOnItemAtPosition<MobileVolumeAdapter.ViewHolder>(3, click()))


    }

//    @Test
//    fun test_showDialog(){
//        onView(withText(R.string.alert_title_text)).check(matches(not(isDisplayed())))
//
//    }




}