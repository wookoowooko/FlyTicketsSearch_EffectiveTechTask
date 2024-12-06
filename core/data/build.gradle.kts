plugins {
    alias(libs.plugins.fly.tickets.android.library)
    alias(libs.plugins.fly.tickets.detekt)
}

android {
    namespace = "io.wookoo.flyticketssearch.data"
}

dependencies {

    projects.core.apply {
        api(domain)
        api(network)
        api(database)
    }
    libs.apply {
        implementation(koin.core)
        testImplementation(junit)
        androidTestImplementation(bundles.android.testing)
    }
    implementation(projects.logger)

}