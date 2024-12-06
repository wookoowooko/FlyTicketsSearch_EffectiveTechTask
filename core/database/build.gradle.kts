plugins {
    alias(libs.plugins.fly.tickets.android.library)
    alias(libs.plugins.ksp)
    alias(libs.plugins.androidx.room)
}

android {
    namespace = "io.wookoo.flyticketssearch.data.database"
}

dependencies {
    libs.apply {
        implementation(room.ktx)
        implementation(koin.core)
        ksp(room.compiler)
        testImplementation(junit)
        androidTestImplementation(bundles.android.testing)
    }

    implementation(projects.core.domain)

}

room {
    schemaDirectory("${rootProject.projectDir}/schemas")
}
