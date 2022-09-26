object Version {
    const val COROUTINE = "1.6.1"
    const val CORE_KTX = "1.8.0"
    const val APPCOMPAT = "1.4.2"
    const val MATERIAL = "1.6.1"
    const val CONSTRAINT_LAYOUT = "2.1.4"
    const val NAVIGATION = "2.5.2"
    const val WORK = "2.7.1"
    const val TEST_JUNIT = "1.1.3"
    const val ESPRESSO = "3.4.0"

    const val JUNIT = "4.13.2"

    const val HILT = "2.42"
    const val HILT_WORK = "1.0.0"

    const val RETROFIT = "2.9.0"
    const val MOSHI = "1.9.3"
    const val OKHTTP = "5.0.0-alpha.7"

    const val ROOM = "2.4.2"

    const val GLIDE = "4.13.2"
    const val GLIDE_COMPILER = "4.12.0"
}

object Library {
    object Coroutine {
        const val COROUTINE = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.COROUTINE}"
        const val COROUTINE_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.COROUTINE}"
    }

    object AndroidX {
        const val CORE_KTX = "androidx.core:core-ktx:${Version.CORE_KTX}"
        const val APPCOMPAT = "androidx.appcompat:appcompat:${Version.APPCOMPAT}"
        const val MATERIAL = "com.google.android.material:material:${Version.MATERIAL}"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Version.CONSTRAINT_LAYOUT}"
        const val NAVIGATION_RUNTIME_KTX = "androidx.navigation:navigation-runtime-ktx:${Version.NAVIGATION}"
        const val NAVIGATION_FRAGMENT_KTX = "androidx.navigation:navigation-fragment-ktx:${Version.NAVIGATION}"
        const val NAVIGATION_UI_KTX = "androidx.navigation:navigation-ui-ktx:${Version.NAVIGATION}"
        const val NAVIGATION_SAFE_ARGS = "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.NAVIGATION}"
        const val WORK = "androidx.work:work-runtime-ktx:${Version.WORK}"
        const val TEST_JUNIT = "androidx.test.ext:junit:${Version.TEST_JUNIT}"
        const val ESPRESSO = "androidx.test.espresso:espresso-core:${Version.ESPRESSO}"
    }

    object JUNIT {
        const val JUNIT = "junit:junit:${Version.JUNIT}"
    }

    object Hilt {
        const val HILT = "com.google.dagger:hilt-android:${Version.HILT}"
        const val HILT_CORE = "com.google.dagger:hilt-core:${Version.HILT}"
        const val HILT_WORK = "androidx.hilt:hilt-work:${Version.HILT_WORK}"
        const val HILT_COMPILER = "com.google.dagger:hilt-compiler:${Version.HILT}"
        const val HILT_ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:${Version.HILT}"
        const val HILT_WORK_COMPILER = "androidx.hilt:hilt-compiler:${Version.HILT_WORK}"
    }

    object Network {
        const val RETROFIT = "com.squareup.retrofit2:retrofit:${Version.RETROFIT}"
        const val MOSHI = "com.squareup.moshi:moshi-kotlin:${Version.MOSHI}"
        const val MOSHI_CONVERTER = "com.squareup.retrofit2:converter-moshi:${Version.RETROFIT}"
        const val OKHTTP = "com.squareup.okhttp3:okhttp:${Version.OKHTTP}"
        const val LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Version.OKHTTP}"
    }

    object Room {
        const val ROOM = "androidx.room:room-runtime:${Version.ROOM}"
        const val ROOM_KTX = "androidx.room:room-ktx:${Version.ROOM}"
        const val ROOM_COMPILER = "androidx.room:room-compiler:${Version.ROOM}"
    }

    object Glide {
        const val GLIDE = "com.github.bumptech.glide:glide:${Version.GLIDE}"
        const val GLIDE_COMPILER = "com.github.bumptech.glide:compiler:${Version.GLIDE_COMPILER}"
    }
}