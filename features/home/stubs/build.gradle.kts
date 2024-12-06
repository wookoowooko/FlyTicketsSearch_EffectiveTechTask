plugins {
    alias(libs.plugins.fly.tickets.feature)
    alias(libs.plugins.fly.tickets.detekt)
}

android {
    namespace = "io.wookoo.flyticketssearch.stubs"
}

dependencies {
    projects.core.apply {
        implementation(data)
    }

    libs.apply {
        testImplementation(junit)
        androidTestImplementation(bundles.android.testing)
    }
}
