package com.example.registration

import android.content.Context
import android.service.autofill.Validators.not
import android.view.View
import android.widget.Toast
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matcher
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.regex.Pattern.matches
import javax.xml.validation.Validator


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Rule
    @JvmField
    val rule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.registration", appContext.packageName)

        //return appContext
    }

    @Test
    fun user_can_enter_first_name() {
        onView(withId(R.id.first_name)).perform(typeText("uday"))
    }

    @Test
    fun user_can_enter_last_name() {
        onView(withId(R.id.last_name)).perform(typeText("reddy"))
    }


    @Test
    fun user_can_enter_first_name_last_name_matches() {
        onView(withId(R.id.first_name)).perform(typeText("raj"))
        onView(withId(R.id.last_name)).perform(typeText("king"))
        onView(withId(R.id.button)).perform(click())
//        onView(withId(R.id.button)).perform(click()).check(matches(not(isEnabled())))


//        onView(withId(R.id.button)).perform(isEnabled() as ViewAction)


        onView(withId(R.id.message)).check(matches("raj(.*)", "raj king"));


    }


    @Test
    fun first_message() {
        onView(withId(R.id.first_name)).perform(typeText("abhijeet"))
        onView(withId(R.id.last_name)).perform(typeText("said"))
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.message)).check(matches("s", "abhijeet said"));


    }

    @Test
    fun txt_Cleared() {

        onView(withId(R.id.first_name)).perform(clearText())
        onView(withId(R.id.last_name)).perform(clearText())


    }

//    @Test
//    fun btn_Enabled() {
//
////        onView(withId(R.id.first_name)).perform(isEnabled() as ViewAction)
//
//        onView(withId(R.id.button)).check(matches(isEnabled()));
//        onView(withText("submit")).perform(click());
//
//        onView(withId(R.id.button)).check(matches(not(isEnabled())));
//
//    }
//
//

    /*private fun Any.check(matches: Boolean) {
        if(matches)
            Toast.makeText(useAppContext(),"Matched",Toast.LENGTH_LONG).show()
        else
            Toast.makeText(useAppContext(),"Not Matched",Toast.LENGTH_LONG).show()


        return matches
    }*/
}

private fun Any.check(matches: Boolean) {


}





