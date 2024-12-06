plugins {
    alias(libs.plugins.fly.tickets.feature)
    alias(libs.plugins.fly.tickets.detekt)
}

android {
    namespace = "io.wookoo.flyticketssearch.all.tickets"
}

dependencies {

    projects.core.apply {
        implementation(data)
    }

    projects.apply {
        implementation(logger)
    }

    libs.apply {
        testImplementation(junit)
        androidTestImplementation(bundles.android.testing)
    }
}