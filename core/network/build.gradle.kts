plugins {
    alias(libs.plugins.fly.tickets.android.library)
    alias(libs.plugins.fly.tickets.detekt)
    alias(libs.plugins.kapt)
}

android {
    namespace = "io.wookoo.flyticketssearch.network"
}

dependencies {

    libs.apply {
        api(bundles.network)
        implementation(koin.core)
        kapt(mock.fit.compiler)
        testImplementation(junit)
        androidTestImplementation(bundles.android.testing)
    }

    implementation(projects.logger)

}