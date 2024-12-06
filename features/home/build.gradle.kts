plugins {
    alias(libs.plugins.fly.tickets.detekt)
    alias(libs.plugins.fly.tickets.feature)
}

android {
    namespace = "io.wookoo.flyticketssearch.tickets"
}

dependencies {
    projects.core.apply {
        implementation(data)
    }
    projects.features.apply {
        implementation(home.ticketsChoose)
        implementation(home.stubs)
    }
    projects.apply {
        implementation(logger)
    }
    libs.apply {
        testImplementation(junit)
        androidTestImplementation(bundles.android.testing)
    }
}