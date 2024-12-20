pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri( "https://jitpack.io") }
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
rootProject.name = "FlyTicketsSearch"

include(":app")

include(":logger")

include(":ui-catalog")

include(":features:home")
include(":features:home:stubs")
include(":features:home:tickets-choose")
include(":features:home:tickets-choose:all-tickets")



include(":core:domain")
include(":core:data")

include(":core:network")
include(":core:database")



