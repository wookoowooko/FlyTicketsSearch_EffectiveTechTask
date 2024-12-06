package io.wookoo.flyticketssearch.convention

import com.android.build.api.dsl.ApplicationExtension
import io.wookoo.flyticketssearch.convention.io.wookoo.flyticketssearch.convention.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            applyPlugins()
            applyDependencies()
            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = 35
            }
        }
    }

    private fun Project.applyPlugins() {
        with(pluginManager) {
            apply("com.android.application")
            apply("org.jetbrains.kotlin.android")
        }
    }

    private fun Project.applyDependencies() {
        dependencies {
            add("implementation", libs.findLibrary("material").get())
            add("implementation", libs.findLibrary("androidx.navigation.ui.ktx").get())
        }
    }

}
