import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {

    // android lifecycle
    private const val lifecycleRuntimeKtx = "2.7.0"
    const val androidxLifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleRuntimeKtx"

    // android UI
    private const val appcompat = "1.6.1"
    private const val material = "1.11.0"
    const val androidxAppcompat = "androidx.appcompat:appcompat:$appcompat"
    const val androidxMaterial = "com.google.android.material:material:$material"

    // hilt
    private const val hiltVersion = "2.51.1"
    const val hiltAgp = "com.google.dagger:hilt-android-gradle-plugin:$hiltVersion"

    // test
    private const val junit = "4.13.2"
    private const val androidJunitVersion = "1.1.5"
    private const val espressoCore = "3.5.1"
    const val junitTesting = "junit:junit:$junit"
    const val androidxJunit = "androidx.test.ext:junit:$androidJunitVersion"
    const val androidxEspressoCore = "androidx.test.espresso:espresso-core:$espressoCore"
}

fun DependencyHandler.unitWithUiTest() {
    test(Dependencies.junitTesting)
    androidTest(Dependencies.androidxJunit)
    androidTest(Dependencies.androidxEspressoCore)
}

fun DependencyHandler.androidLifeCycle() {
    implementation(Dependencies.androidxLifecycleRuntimeKtx)
}

fun DependencyHandler.androidUI() {
    implementation(Dependencies.androidxAppcompat)
    implementation(Dependencies.androidxMaterial)
}