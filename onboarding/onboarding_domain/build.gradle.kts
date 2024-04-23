plugins {
    `android-library`
    `kotlin-android`
}

apply(from = "$rootDir/base-module.gradle")

android {
    namespace = "com.annguyenhoang.onboarding_domain"
}

dependencies {
    coreModule()
}