pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    // (A) Direkt festnageln
    plugins {
        id("com.android.application") version "8.11.1"
        id("com.android.library") version "8.11.1"
    }

    // (B) Sicherheitshalber auch erzwingen
    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace == "com.android") {
                useVersion("8.11.1")
            }
        }
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
