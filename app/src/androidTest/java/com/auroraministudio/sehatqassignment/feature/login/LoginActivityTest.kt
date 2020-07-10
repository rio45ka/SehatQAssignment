package com.auroraministudio.sehatqassignment.feature.login

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.auroraministudio.sehatqassignment.R
import com.auroraministudio.sehatqassignment.base.ToastMatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test

/**
 * Created by Rio on 10/07/20.
 * Email rio.aska35@gmail.com
 */
@ExperimentalCoroutinesApi
class LoginActivityTest {

    @get:Rule
    var activityRule = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun signInUsernamePasswordError() {
        onView(withText("SIGN IN")).perform(click())
        onView(withText("Input for login still empty!")).inRoot(ToastMatcher()).check(
            matches(
                isDisplayed()
            )
        )
    }

    @Test
    fun signInUsernamePasswordSuccessfully() {
        onView(withId(R.id.et_username_login)).perform(typeText("usernameUser"))
        onView(withId(R.id.input_password_login)).perform(typeText("passwordUser"))
        onView(withText("SIGN IN")).perform(click())
        onView(withId(R.id.pb_login)).check(matches(isDisplayed()))
    }

}