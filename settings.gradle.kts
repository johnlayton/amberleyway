pluginManagement {
  repositories {
    gradlePluginPortal()
//    mavenLocal()
//    mavenCentral()
//    jcenter()
//    maven("https://plugins.gradle.org/m2/")
//    maven("https://jitpack.io")
  }
  resolutionStrategy {
    eachPlugin {
      if (requested.id.id == "com.google.protobuf") {
        useModule("com.google.protobuf:protobuf-gradle-plugin:${requested.version}")
      }
    }
  }
}

rootProject.name = "amberleyway"

include("app", "api", "sal", "model")