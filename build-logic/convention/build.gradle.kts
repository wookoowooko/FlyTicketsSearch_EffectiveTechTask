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
            id = "fly.tikets.detekt"
            implementationClass = "io.wookoo.flyticketssearch.convention.DetektConventionPlugin"
        }
    }
}