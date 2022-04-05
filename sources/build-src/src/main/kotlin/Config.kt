import org.gradle.api.JavaVersion

@Suppress("unused")
object Config {
    const val applicationId = "ru.chernakov.sampler"

    const val compileSdkVersion = 32
    const val minSdkVersion = 26
    const val targetSdkVersion = 32

    const val buildToolsVersion = "30.0.2"

    val javaVersion = JavaVersion.VERSION_11
}

object BuildTypes {
    const val debug = "debug"
    const val release = "release"
}