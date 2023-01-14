plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 33

    defaultConfig {
        applicationId = "little.goose.account"
        minSdk = 26
        targetSdk = 33
        versionCode = 15
        versionName = "1.8.7"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = freeCompilerArgs.toMutableList().apply {
            addAll(
                listOf(
                    "-Xjvm-default=all",
                    "-Xskip-prerelease-check",
                    "-Xopt-in=kotlin.RequiresOptIn",
                    "-Xopt-in=androidx.compose.material.ExperimentalMaterialApi",
                    "-Xopt-in=androidx.compose.foundation.ExperimentalFoundationApi",
                    "-Xopt-in=com.google.accompanist.insets.ExperimentalAnimatedInsets",
                    "-Xopt-in=com.google.accompanist.pager.ExperimentalPagerApi",
                    "-Xopt-in=androidx.compose.material3.ExperimentalMaterial3Api",
                )
            )
        }
    }

    buildFeatures {
        viewBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }

}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.recyclerview:recyclerview:1.2.1")

    implementation("androidx.fragment:fragment-ktx:1.4.1")
    implementation("androidx.activity:activity-ktx:1.6.1")

    //SplashScreen
    implementation("androidx.core:core-splashscreen:1.0.0")

    val compose_version = "1.3.2"

    //compose
    implementation("androidx.activity:activity-compose:1.6.1")
    implementation("androidx.compose.ui:ui:$compose_version")
    implementation("androidx.compose.ui:ui-tooling:$compose_version")
    implementation("androidx.compose.ui:ui-tooling-preview:$compose_version")
    implementation("androidx.compose.animation:animation:$compose_version")
    implementation("androidx.compose.material3:material3:1.1.0-alpha03")
    implementation("androidx.compose.foundation:foundation:$compose_version")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.0-alpha03")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$compose_version")

    val room_version = "2.4.2"
    //Room数据库
    implementation("androidx.room:room-runtime:$room_version")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    annotationProcessor("androidx.room:room-compiler:$room_version")
    kapt("androidx.room:room-compiler:$room_version")
    implementation("androidx.room:room-ktx:$room_version")

    //协程
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    val lifecycle_version = "2.4.1"

    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")//lifecycleScope
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")//viewModelScope
    implementation("androidx.lifecycle:lifecycle-process:$lifecycle_version")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.4")

    //MPAndroidChart
    implementation("com.github.PhilJay:MPAndroidChart:v3.1.0")

    //富文本
    implementation(project(":RichText"))
    //自定义Calendar
    implementation(project(":calendarview"))

    //DataStore
    implementation("androidx.datastore:datastore-preferences:1.0.0")

}