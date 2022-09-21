plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    compileSdk = AppConfig.COMPILE_SDK

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(project(":domain"))
    
    implementation(Library.Coroutine.COROUTINE)

    implementation(Library.AndroidX.WORK)

    implementation(Library.Hilt.HILT)
    implementation(Library.Hilt.HILT_WORK)
    kapt(Library.Hilt.HILT_COMPILER)
    kapt(Library.Hilt.HILT_WORK_COMPILER)

    implementation(Library.Network.RETROFIT)
    implementation(Library.Network.MOSHI)
    implementation(Library.Network.MOSHI_CONVERTER)
    implementation(Library.Network.OKHTTP)
    implementation(Library.Network.LOGGING_INTERCEPTOR)

    implementation(Library.Room.ROOM)
    implementation(Library.Room.ROOM_KTX)
    kapt(Library.Room.ROOM_COMPILER)
}