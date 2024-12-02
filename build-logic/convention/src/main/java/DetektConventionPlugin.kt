package io.wookoo.flyticketssearch.convention

import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType


class DetektConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("io.gitlab.arturbosch.detekt")
            dependencies {
                "detektPlugins"(libs.findLibrary("detekt-formatting").get())
            }

            extensions.getByType<DetektExtension>()
                .apply {
                    config.setFrom(rootProject.file("detekt.yml"))
                    parallel = true
                    buildUponDefaultConfig = true
                    autoCorrect = true
                    allRules = false
                    baseline = file("$projectDir/config/baseline.xml")
                }


            // Настройка отчетов
            tasks.withType<Detekt>().configureEach {
                reports {
                    html.required.set(true) // HTML отчет
                    xml.required.set(true) // XML отчет для CI/CD
                    sarif.required.set(true) // SARIF отчет для GitHub
                    md.required.set(true) // Markdown отчет
                }
                jvmTarget = "1.8" // Установка jvmTarget для анализа Detekt
            }

            // Настройка jvmTarget для создания baseline (файла базовых ошибок)
            tasks.withType<DetektCreateBaselineTask>().configureEach {
                jvmTarget = "1.8"
            }

            tasks.withType<Detekt>().configureEach {
                autoCorrect = true
            }
        }
    }
}
