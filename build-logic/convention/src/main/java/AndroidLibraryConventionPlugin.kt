package io.wookoo.flyticketssearch.convention

import com.android.build.api.dsl.LibraryExtension
import io.wookoo.flyticketssearch.convention.io.wookoo.flyticketssearch.convention.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin


class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            applyPlugins()
            applyDependencies()
            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                testOptions.apply {
                    targetSdk = 35
                    animationsDisabled = true
                }
                defaultConfig.testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }
        }
    }

    private fun Project.applyPlugins() {
        with(pluginManager) {
            apply("com.android.library")
            apply("org.jetbrains.kotlin.android")

        }
    }

    private fun Project.applyDependencies() {
        dependencies {
            add("testImplementation", kotlin("test"))
            add("androidTestImplementation", (kotlin("test")))
            add("implementation", libs.findLibrary("kotlinx-coroutines-core").get())
        }
    }
}