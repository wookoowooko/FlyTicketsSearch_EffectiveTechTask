package io.wookoo.flyticketssearch.data.navigation

import android.os.Bundle

interface INavigationCallback {
    fun navigateToHardWayStubFragment()
    fun navigateToDaysOffStubFragment()
    fun navigateToFireTicketsStubFragment()
    fun navigateToSearchResultsFragment(bundle: Bundle)
    fun navigateToAllTicketsFragment()
    fun goBack()
}
