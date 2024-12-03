plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kapt) apply false
    //    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.androidx.room) apply false
    alias(libs.plugins.detekt) apply false
}

tasks.register("detektAll") {
    dependsOn(
        subprojects.flatMap { project ->
            listOf(
                "${project.path}:detektDebug",
                "${project.path}:detektMain"
            ).filter { taskName ->
                project.tasks.findByPath(taskName) != null
            }
        }
    )
}