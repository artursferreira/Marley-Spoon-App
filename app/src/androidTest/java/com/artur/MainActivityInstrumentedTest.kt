package com.artur

import android.content.Context
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.artur.marleyspoon.R
import com.artur.marleyspoon.main.presentation.model.RecipeView
import com.artur.marleyspoon.main.presentation.ui.MainActivity
import com.artur.marleyspoon.main.presentation.ui.MainViewModel
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
class MainActivityInstrumentedTest  {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setup() {
        scenario = launchActivity()
    }

    @Test
    fun assert_recipes_error_is_visible() {
        scenario.onActivity {
            it.showItems(emptyList())
        }

        Espresso.onView(withId(R.id.recipes_empty))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

    }

    @Test
    fun assert_recipes_list_is_visible() {

        Espresso.onView(withId(R.id.recipes_recyclerview))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

    }

}