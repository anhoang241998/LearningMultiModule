import org.gradle.api.artifacts.dsl.DependencyHandler

object Compose {
    private const val activityCompose = "1.9.0"
    const val androidxActivityCompose = "androidx.activity:activity-compose:$activityCompose"

    const val composeCompiler = "1.5.12"
    private const val composeBoomVersion = "2024.04.01"
    const val androidXComposeBom = "androidx.compose:compose-bom:$composeBoomVersion"
    const val androidxUi = "androidx.compose.ui:ui"
    const val androidxUiGraphics = "androidx.compose.ui:ui-graphics"
    const val androidxUiTooling = "androidx.compose.ui:ui-tooling"
    const val androidxUiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    val androidxUiTestManifest = "androidx.compose.ui:ui-test-manifest"
    const val androidxUiTestJunit4 = "androidx.compose.ui:ui-test-junit4"
    const val androidxUiTestJunit4WithVersion = "androidx.compose.ui:ui-test-junit4:1.6.6"
    const val androidxMaterial3 = "androidx.compose.material3:material3"
    const val androidxMaterial3WithVersion = "androidx.compose.material3:material3:1.2.1"
    const val runtime = "androidx.compose.runtime:runtime"
    const val compiler = "androidx.compose.compiler:compiler:$composeCompiler"

    // navigation
    private const val navigationVersion = "2.7.7"
    const val navigation = "androidx.navigation:navigation-compose:$navigationVersion"

    // lifecycle-viewmodel-compose
    private const val lifecycleVersion = "2.7.0"
    const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion"

    // hilt navigation
    private const val hiltNavigationComposeVersion = "1.2.0"
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:$hiltNavigationComposeVersion"
}

fun DependencyHandler.compose() {
    implementation(Compose.androidxActivityCompose)
    implementation(platform(Compose.androidXComposeBom))
    implementation(Compose.androidxUi)
    implementation(Compose.androidxMaterial3)
    implementation(Compose.androidxUiGraphics)
    implementation(Compose.androidxUiToolingPreview)
    implementation(Compose.runtime)
    implementation(Compose.compiler)
    implementation(Compose.navigation)
    implementation(Compose.viewModelCompose)
    implementation(Compose.hiltNavigationCompose)
    debugImplementation(Compose.androidxUiTooling)
    debugImplementation(Compose.androidxUiTestManifest)
    androidTest(platform(Compose.androidXComposeBom))
    test(Compose.androidxUiTestJunit4)
    androidTest(Compose.androidxUiTestJunit4)
}
