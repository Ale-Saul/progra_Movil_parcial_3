plugins {
    alias(libs.plugins.calyr.jvm.library)
    alias(libs.plugins.kotlinSerialization)
}

dependencies {
    //serialization
    implementation(libs.kotlinx.serialization.json)
}