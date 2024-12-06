plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

kotlin {
    compilerOptions {
        apiVersion.set(org.jetbrains.kotlin.gradle.dsl.KotlinVersion.KOTLIN_2_0)
    }
}

dependencies {
    compileOnly(libs.android.plugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.detekt.gradlePlugin)
}
gradlePlugin {
    plugins {
        register("kotlinDetekt") {
            id = "fly.tickets.detekt"
            implementationClass = "io.wookoo.flyticketssearch.convention.DetektConventionPlugin"
        }
        register("androidApplication") {
            id = "fly.tickets.android.application"
            implementationClass = "io.wookoo.flyticketssearch.convention.AndroidApplicationConventionPlugin"
        }

        register("androidLibrary"){
            id = "fly.tickets.android.library"
            implementationClass = "io.wookoo.flyticketssearch.convention.AndroidLibraryConventionPlugin"
        }
        register("jvmLibrary"){
            id = "fly.tickets.jvm.library"
            implementationClass = "io.wookoo.flyticketssearch.convention.JvmLibraryConventionPlugin"
        }
    }
}