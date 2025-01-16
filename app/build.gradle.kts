plugins {
    alias(libs.plugins.android.application)  // Android application plugin
    alias(libs.plugins.kotlin.android)        // Kotlin Android plugin
//    alias(libs.plugins.kotlin.plugin.compose) // Kotlin Compose plugin
    kotlin("kapt")                           // Enable KAPT for annotation processing
    alias(libs.plugins.hilt.android)

}

android {
    namespace = "mo.ed.weather"
    compileSdk = 35

    defaultConfig {
        applicationId = "mo.ed.weather"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"  // The version of the compiler extension for Kotlin 1.8.10
    }
    kotlinOptions {
        jvmTarget = "19"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
//    implementation(libs.coil.svg)
    implementation(libs.java.poet)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.coil.compose)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.volley)
    implementation(libs.hilt.lifecycle.viewmode)
    implementation(libs.squareup.retrofit2)
    implementation(libs.squareup.retrofit2.gson)
    implementation(libs.dagger.hilt.android)
    implementation(libs.hilt.plugin)
    kapt(libs.com.google.dagger.kapt)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}