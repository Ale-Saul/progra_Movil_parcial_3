plugins {
    alias(libs.plugins.calyr.jvm.library)
}

dependencies {
    implementation(project(":domain"))
}