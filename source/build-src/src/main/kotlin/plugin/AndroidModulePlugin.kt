package plugin

import BuildTypes
import Config
import Plugins
import internal.libraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

class AndroidModulePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            applyPlugins()
            applyLibraryConfig()
            applyDefaultDependencies()
        }
    }

    private fun Project.applyPlugins() {
        apply(plugin = Plugins.androidLibrary)
    }

    private fun Project.applyLibraryConfig() {
        libraryExtension.apply {
            compileSdk = Config.compileSdkVersion

            defaultConfig {
                minSdk = Config.minSdkVersion
                targetSdk = Config.targetSdkVersion
            }

            buildTypes.getByName(BuildTypes.debug) {
                isDefault = true
            }

            buildTypes.getByName(BuildTypes.release) {
            }

            compileOptions {
                sourceCompatibility = Config.javaVersion
                targetCompatibility = Config.javaVersion
            }
        }
    }

    private fun Project.applyDefaultDependencies() {
        dependencies.apply {
        }
    }
}