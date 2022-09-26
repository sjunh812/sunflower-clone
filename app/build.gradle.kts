import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdk = AppConfig.COMPILE_SDK

    defaultConfig {
        applicationId = AppConfig.APPLICATION_ID
        minSdk = AppConfig.MIN_SDK
        targetSdk = AppConfig.TARGET_SDK
        versionCode = AppConfig.VERSION_CODE
        versionName = AppConfig.VERSION_NAME
        testInstrumentationRunner = AppConfig.TEST_INSTRUMENTATION_RUNNER

        buildConfigField("String", "UNSPLASH_ACCESS_KEY", getApiKey("UNSPLASH_ACCESS_KEY"))
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))

    implementation(Library.AndroidX.CORE_KTX)
    implementation(Library.AndroidX.APPCOMPAT)
    implementation(Library.AndroidX.MATERIAL)
    implementation(Library.AndroidX.CONSTRAINT_LAYOUT)
    implementation(Library.AndroidX.NAVIGATION_RUNTIME_KTX)
    implementation(Library.AndroidX.NAVIGATION_FRAGMENT_KTX)
    implementation(Library.AndroidX.NAVIGATION_UI_KTX)
    androidTestImplementation(Library.AndroidX.TEST_JUNIT)
    androidTestImplementation(Library.AndroidX.ESPRESSO)

    testImplementation(Library.JUNIT.JUNIT)

    implementation(Library.Hilt.HILT)
    implementation(Library.Hilt.HILT_WORK)
    kapt(Library.Hilt.HILT_COMPILER)
    kapt(Library.Hilt.HILT_WORK_COMPILER)

    implementation(Library.Network.RETROFIT)
    implementation(Library.Network.MOSHI)
    implementation(Library.Network.MOSHI_CONVERTER)
    implementation(Library.Network.OKHTTP)
    implementation(Library.Network.LOGGING_INTERCEPTOR)

    implementation(Library.Glide.GLIDE)
    kapt(Library.Glide.GLIDE_COMPILER)
}

fun getApiKey(propertyKey: String): String = gradleLocalProperties(rootDir).getProperty(propertyKey)