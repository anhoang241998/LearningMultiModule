import org.gradle.api.artifacts.dsl.DependencyHandler

object Room {
    private const val version = "2.5.0"
    const val roomRuntime = "androidx.room:room-runtime:$version"
    const val roomCompiler = "androidx.room:room-compiler:$version"
    const val roomKtx = "androidx.room:room-ktx:$version"
}

fun DependencyHandler.room() {
    implementation(Room.roomKtx)
    implementation(Room.roomRuntime)
    kapt(Room.roomCompiler)
}