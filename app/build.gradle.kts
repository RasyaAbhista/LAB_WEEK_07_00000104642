plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.android.libraries.mapsplatform.secrets.gradle.plugin)
}

android {
    namespace = "com.example.lab_week_07"
    compileSdk = 36 // ✅ sesuai requirement androidx.core 1.17.0+

    defaultConfig {
        applicationId = "com.example.lab_week_07"
        minSdk = 24
        targetSdk = 36 // ✅ disamakan agar runtime behavior sesuai SDK 36
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
        // ✅ gunakan Java 17 (default untuk Android Studio Koala+)
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // 🧱 Core dependencies
    implementation(libs.androidx.core.ktx)              // androidx.core:core-ktx:1.17.0
    implementation(libs.androidx.appcompat)             // androidx.appcompat:appcompat:1.7.0
    implementation(libs.material)                       // com.google.android.material:material:1.12.0
    implementation(libs.androidx.constraintlayout)      // androidx.constraintlayout:constraintlayout:2.2.0

    // 🗺️ Google Maps
    implementation(libs.play.services.maps)             // com.google.android.gms:play-services-maps
    implementation("com.google.android.gms:play-services-location:21.3.0")

    // 🧩 Activity & Fragment KTX (modern lifecycle aware)
    implementation("androidx.activity:activity-ktx:1.9.3")
    implementation("androidx.fragment:fragment-ktx:1.8.2")

    // 🧪 Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
