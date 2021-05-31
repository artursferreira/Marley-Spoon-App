package com.artur

import android.content.Intent
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.artur.marleyspoon.R
import com.artur.marleyspoon.detail.DetailActivity
import com.artur.marleyspoon.main.presentation.model.RecipeView
import com.artur.marleyspoon.main.presentation.ui.MainActivity.Companion.EXTRA_RECIPE
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
class DetailActivityInstrumentedTest {

    private lateinit var scenario: ActivityScenario<DetailActivity>

    @Before
    fun setup() {
        val recipe = RecipeView(
            title = "Test",
            description = "Description test",
            imageUrl = "https://picsum.photos/id/237/200/300"
        )

        val intent = Intent(ApplicationProvider.getApplicationContext(), DetailActivity::class.java)
            .putExtra(EXTRA_RECIPE, recipe)

        scenario = launchActivity(intent)
    }

    @Test
    fun assert_recipe_info_is_visible() {

        Espresso.onView(withId(R.id.recipe_imageview))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

        Espresso.onView(withId(R.id.recipe_description))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

        Espresso.onView(withId(R.id.recipe_title))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

    }

}