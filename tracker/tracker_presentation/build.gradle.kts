plugins {
    `android-library`
    `kotlin-android`
}

apply(from = "$rootDir/compose-module.gradle")

android {
    namespace = "com.annguyenhoang.tracker_presentation"
}

dependencies {
    coreModule()
    trackerDomainModule()
    coil()
}