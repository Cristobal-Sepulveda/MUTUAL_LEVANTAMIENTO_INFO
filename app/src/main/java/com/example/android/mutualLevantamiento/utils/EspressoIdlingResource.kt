package com.example.android.mutualLevantamiento.utils

import androidx.test.espresso.idling.CountingIdlingResource

//TODO 11.4
    object EspressoIdlingResource {

        private const val RESOURCE = "GLOBAL"

        @JvmField
        val countingIdlingResource = CountingIdlingResource(RESOURCE)

        fun increment() {
            countingIdlingResource.increment()
        }

        fun decrement() {
            if (!countingIdlingResource.isIdleNow) {
                countingIdlingResource.decrement()
            }
        }
    }

    //TODO 11.5
    inline fun <T> wrapEspressoIdlingResource(function: () -> T): T {
        // Espresso does not work well with coroutines yet. See
        // https://github.com/Kotlin/kotlinx.coroutines/issues/982
        EspressoIdlingResource.increment() // Set app as busy.
        return try {
            function()
        } finally {
            EspressoIdlingResource.decrement() // Set app as idle.
        }
    }
