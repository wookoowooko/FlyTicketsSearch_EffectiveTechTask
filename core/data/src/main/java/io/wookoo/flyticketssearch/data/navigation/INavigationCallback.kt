package io.wookoo.flyticketssearch.data.navigation

interface INavigationCallback {
    fun navigateToHardWayStubFragment()
    fun navigateToDaysOffStubFragment()
    fun navigateToFireTicketsStubFragment()
    fun goBack()
}