package com.auroraministudio.sehatqassignment.feature.dashboard.view

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.rule.ActivityTestRule
import com.auroraministudio.sehatqassignment.R
import com.auroraministudio.sehatqassignment.base.ToastMatcher
import com.auroraministudio.sehatqassignment.utils.SampleData
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test

/**
 * Created by Rio on 10/07/20.
 * Email rio.aska35@gmail.com
 */
@ExperimentalCoroutinesApi
class DashboardActivityTest {

    private val productsDummy = SampleData().product


    @get:Rule
    var activityRule = ActivityTestRule(DashboardActivity::class.java)

    @Test
    fun testBottomNavBar() {
        onView(withId(R.id.feedFragment)).perform(click())
        onView(withId(R.id.tv_title_feed)).check(matches(isDisplayed()))
        onView(withId(R.id.cartFragment)).perform(click())
        onView(withId(R.id.tv_title_cart)).check(matches(isDisplayed()))
        onView(withId(R.id.profileFragment)).perform(click())
        onView(withId(R.id.tv_title_toolbar_profile_fragment)).check(matches(isDisplayed()))
        onView(withId(R.id.homeFragment)).perform(click())
        onView(withId(R.id.toolbar_home)).check(matches(isDisplayed()))
    }

    @Test
    fun loadDataProduct() {
        onView(withId(R.id.rv_product_home)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_product_home)).perform(
            scrollToPosition<RecyclerView.ViewHolder>(
                productsDummy.size
            )
        )
    }

    @Test
    fun openSearchPage() {
        onView(withId(R.id.btn_search_home)).perform(click())
        onView(withId(R.id.et_search_keyword)).check(matches(isDisplayed()))
    }

    @Test
    fun searchProductInSearchPage() {
        onView(withId(R.id.btn_search_home)).perform(click())
        onView(withId(R.id.et_search_keyword)).check(matches(isDisplayed()))
        onView(withId(R.id.et_search_keyword)).perform(typeText("baju"))
        onView(withId(R.id.rv_product_search)).check(matches(isDisplayed()))
    }

    @Test
    fun loadDetailPage() {
        onView(withId(R.id.rv_product_home)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.iv_cover_detail_product)).check(matches(isDisplayed()))
    }

    @Test
    fun flowBuyProduct() {
        onView(withId(R.id.rv_product_home)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )
        onView(withId(R.id.iv_cover_detail_product)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_buy_detail_product)).perform(click())
        onView(withText("Success buy product!")).inRoot(ToastMatcher()).check(
            matches(
                isDisplayed()
            )
        )
        onView(withId(R.id.iv_back_search_detail_product)).perform(click())
        onView(withId(R.id.profileFragment)).perform(click())
        onView(withId(R.id.tv_title_toolbar_profile_fragment)).check(matches(isDisplayed()))
    }

    @Test
    fun loadDetailCartPage() {
        onView(withId(R.id.profileFragment)).perform(click())
        onView(withId(R.id.tv_title_toolbar_profile_fragment)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_cart_product)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )
        onView(withId(R.id.iv_cover_detail_product_cart)).check(matches(isDisplayed()))
    }


}