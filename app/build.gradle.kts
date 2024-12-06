plugins {
    alias(libs.plugins.fly.tickets.android.application)
    alias(libs.plugins.fly.tickets.detekt)
}

android {
    namespace = "io.wookoo.flyticketssearch"

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {

    project.apply{
        implementation(projects.uiCatalog)
        implementation(projects.logger)
    }
    projects.core.apply {
        implementation(data)
    }
    projects.features.apply {
        implementation(home)
    }
    libs.apply {
        implementation(bundles.koin.bundle)
    }
}