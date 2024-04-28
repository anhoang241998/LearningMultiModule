import org.gradle.api.artifacts.dsl.DependencyHandler

object Coroutine {
    private const val version = "1.8.0"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
}

fun DependencyHandler.coroutine() {
    implementation(Coroutine.coroutines)
}
