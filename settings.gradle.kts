pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
        id("com.android.application") version "8.11.1"
        id("com.android.library") version "8.11.1"
        // Falls ihr kotlin-plugins nutzt, lasst deren Version wie bisher
        // (oder setzt sie hier ebenfalls explizit, wenn ihr sie zentral steuern wollt)
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://central.sonatype.com/repository/maven-snapshots/")
            mavenContent { snapshotsOnly() }
        }
        maven {
            url = uri("https://jitpack.io")
        }
        mavenLocal()
    }
}

rootProject.name = "EUDI Wallet"
include(":app")
