package com.bogdash.fragments_2

import android.os.Bundle

interface Router {
    fun showDetailFragment(
        bundle: Bundle? = null
    )
}