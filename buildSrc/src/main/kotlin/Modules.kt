import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Modules {
    const val app = ":app"

    const val core = ":core"

    const val onboardingDomain = ":onboarding:onboarding_domain"
    const val onboardingPresentation = ":onboarding:onboarding_presentation"

    const val trackerData = ":tracker:tracker_data"
    const val trackerDomain = ":tracker:tracker_domain"
    const val trackerPresentation = ":tracker:tracker_presentation"
}

fun DependencyHandler.coreModule() {
    implementation(project(Modules.core))
}

fun DependencyHandler.onboardingDomainModule() {
    implementation(project(Modules.onboardingDomain))
}

fun DependencyHandler.onboardingPresentationModule() {
    implementation(project(Modules.onboardingPresentation))
}

fun DependencyHandler.trackerDataModule() {
    implementation(project(Modules.trackerData))
}

fun DependencyHandler.trackerDomainModule() {
    implementation(project(Modules.trackerDomain))
}

fun DependencyHandler.trackerPresentationModule() {
    implementation(project(Modules.trackerPresentation))
}

fun DependencyHandler.allModules() {
    coreModule()
    onboardingDomainModule()
    onboardingPresentationModule()
    trackerDataModule()
    trackerDomainModule()
    trackerPresentationModule()
}