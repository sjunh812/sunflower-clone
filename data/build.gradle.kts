plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(project(":domain"))

    implementation(Library.Network.RETROFIT)
    implementation(Library.Network.MOSHI)
    implementation(Library.Network.MOSHI_CONVERTER)
    implementation(Library.Network.OKHTTP)
    implementation(Library.Network.LOGGING_INTERCEPTOR)

    implementation(Library.Hilt.HILT_CORE)
    implementation(Library.Hilt.HILT_COMPILER)
}