pluginManagement {
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
    }
}

rootProject.name = "balldontlie"
include(":app")
include(":core:common")
include(":core:network")
include(":core:database")
include(":core:ui")
include(":core:testing")
include(":domain")
include(":data")
include(":feature:games")
include(":feature:teams")
include(":feature:players")
include(":feature:favorites")
