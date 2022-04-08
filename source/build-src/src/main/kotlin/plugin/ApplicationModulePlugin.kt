package plugin

import AndroidDependencies
import BuildTypes
import Config
import Plugins
import internal.applicationExtension
import internal.baseModulesDirectory
import internal.featureModulesDirectory
import internal.getGitVersionCode
import internal.getGitVersionName
import internal.implementation
import internal.isGradleProjectDir
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.project
import java.io.File

class ApplicationModulePlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.run {
            applyPlugins()
            applyApplicationConfig()
            applyDependencies()
        }
    }

    private fun Project.applyPlugins() {
        plugins.run {
            apply(plugin = Plugins.androidApplication)
            apply(plugin = Plugins.kotlinAndroid)
        }
    }

    private fun Project.applyApplicationConfig() {
        applicationExtension.apply {
            compileSdk = Config.compileSdkVersion
            buildToolsVersion = Config.buildToolsVersion

            defaultConfig {
                applicationId = Config.applicationId
                minSdk = Config.minSdkVersion
                targetSdk = Config.targetSdkVersion
                versionCode = getGitVersionCode()
                versionName = getGitVersionName()
            }

            buildTypes {
                getByName(BuildTypes.debug) {
                    isMinifyEnabled = false
                }

                getByName(BuildTypes.release) {
                    isMinifyEnabled = true
                }
            }

            compileOptions {
                sourceCompatibility = Config.javaVersion
                targetCompatibility = Config.javaVersion
            }
        }
    }

    private fun Project.applyDependencies() {
        dependencies.apply {
            // Base modules
            File(baseModulesDirectory).listFiles()?.forEach { baseModule ->
                if (baseModule.isDirectory && baseModule.isGradleProjectDir) {
                    implementation(project(":${baseModule.name}"))
                    println(":${baseModule.name} added to application")
                }
            }

            // Feature modules
            File(featureModulesDirectory).listFiles()?.forEach { featureModule ->
                if (featureModule.isDirectory && featureModule.isGradleProjectDir) {
                    implementation(project(":${featureModule.name}"))
                }
            }

            // Libraries
            implementation(AndroidDependencies.appCompat)
            implementation(AndroidDependencies.material)
            implementation(AndroidDependencies.constraintLayout)
        }
    }
}