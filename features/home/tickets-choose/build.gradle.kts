plugins {
    alias(libs.plugins.fly.tickets.feature)
    alias(libs.plugins.fly.tickets.detekt)
}

android {
    namespace = "io.wookoo.flyticketssearch.search.results"
}

dependencies {
    projects.core.apply {
        implementation(data)
    }
    projects.features.apply {
        implementation(home.ticketsChoose.allTickets)
    }
    projects.apply {
        implementation(logger)
    }
    libs.apply {
        testImplementation(junit)
        androidTestImplementation(bundles.android.testing)
    }
}