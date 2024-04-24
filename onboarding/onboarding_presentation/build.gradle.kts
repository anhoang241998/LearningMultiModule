plugins {
    `android-library`
    `kotlin-android`
}

apply(from = "$rootDir/compose-module.gradle")

android {
    namespace = "com.annguyenhoang.onboarding_presentation"
}

dependencies {
    coreModule()
    coreUiModule()
    onboardingDomainModule()
}