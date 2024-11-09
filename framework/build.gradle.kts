plugins {
    alias(libs.plugins.calyr.android.library)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.calyr.framework"
}

dependencies {
    implementation(libs.retrofit)
    //networking bundle
    implementation(libs.bundles.networking)

    //local bundle room
    implementation(libs.bundles.local)
    annotationProcessor(libs.room.compiler)
    ksp(libs.room.compiler)
    testImplementation(libs.room.testing)

    implementation(project(":data"))
    implementation(project(":domain"))
}