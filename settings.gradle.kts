/* Project Settings */

rootProject.name = "Playground"
val modulesConfiguratorPath = "/gradle/scripts/modules-configurator.gradle.kts"

// Attach modules
apply(from = File(modulesConfiguratorPath))

// Enable features
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

// Management settings
@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    resolutionStrategy {
        eachPlugin {
            val kotlinVersion = "1.6.20"
            val androidGradleVersion = "7.1.3"

            val pluginId = requested.id.id
            when {
                pluginId.startsWith("org.jetbrains.kotlin") -> useVersion(kotlinVersion)
                pluginId.startsWith("com.android.") -> useVersion(androidGradleVersion)
            }
        }
    }
}