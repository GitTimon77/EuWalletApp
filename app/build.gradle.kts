plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "eu.eudi.wallet.app"
    compileSdk = 34
    defaultConfig {
        applicationId = "eu.eudi.wallet"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "0.1.0"
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation("eu.europa.ec.eudi:eudi-lib-android-wallet-core:0.18.0")
    implementation("eu.europa.ec.eudi:eudi-lib-android-wallet-document-manager:0.12.0")
    implementation("eu.europa.ec.eudi:eudi-lib-android-iso18013-data-transfer:0.8.0")
    implementation("eu.europa.ec.eudi:eudi-lib-android-rqes-ui:0.3.0")

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4")
    implementation("androidx.activity:activity-ktx:1.9.1")
    implementation("com.google.android.material:material:1.12.0")
}

