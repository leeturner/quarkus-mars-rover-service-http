pluginManagement {
    val quarkusPluginVersion: String by settings
    val quarkusPluginId: String by settings
    repositories {
        mavenCentral()
        gradlePluginPortal()
        mavenLocal()
    }
    plugins { id(quarkusPluginId) version quarkusPluginVersion }
}

rootProject.name = "quarkus-mars-rover-service-http"
