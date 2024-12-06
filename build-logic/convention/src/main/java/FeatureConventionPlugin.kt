package io.wookoo.flyticketssearch.convention

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class FeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            applyPlugins()
            applyDependencies()
        }
    }

    private fun Project.applyPlugins() {
        pluginManager.apply {
            apply("fly.tickets.android.library")
        }
    }


    private fun Project.applyDependencies() {
        dependencies {
            add("implementation", project(":ui-catalog"))
            add("implementation", libs.findLibrary("androidx-constraintlayout").get())
            add("implementation", libs.findLibrary("androidx-lifecycle-viewmodel-ktx").get())
            add("implementation", libs.findLibrary("androidx-navigation-fragment-ktx").get())
            add("implementation", libs.findLibrary("androidx-navigation-ui-ktx").get())
            add("implementation", libs.findLibrary("androidx.core.ktx").get())
            add("implementation", libs.findLibrary("androidx.appcompat").get())
            add("implementation", libs.findLibrary("material").get())
            add("implementation", libs.findLibrary("adapter-delegates").get())
            add("implementation", libs.findBundle("koin-bundle").get())

        }
    }
}

