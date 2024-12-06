plugins {
    alias(libs.plugins.fly.tickets.jvm.library)
}

dependencies{
    implementation(libs.koin.core)
    testImplementation(libs.junit)
}