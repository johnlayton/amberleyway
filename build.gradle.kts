import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
  repositories {
    mavenLocal()
    mavenCentral()
    maven("https://jitpack.io")
  }
  dependencies {
//    classpath("au.com.mebank.integration:riverhilldrive:0.0.1-3-gf2aa65a")
//    classpath("com.github.johnlayton:riverhilldrive:0.0.1")
    classpath("com.github.johnlayton.riverhilldrive:integration.gradle.plugin:0.0.1-3-gf2aa65a")
  }
  configurations {
    classpath {
      resolutionStrategy {
        cacheChangingModulesFor(0, "seconds")
      }
    }
  }
}

plugins {
//  base
//  java
//  publishing

  `kotlin-dsl`
  `maven-publish`

  kotlin("jvm") version "1.3.61" apply false
  kotlin("kapt") version "1.3.61" apply false

  kotlin("plugin.spring") version "1.3.61" apply false

  id("io.spring.dependency-management") version "1.0.8.RELEASE" apply false
  id("org.springframework.boot") version "2.2.0.RELEASE" apply false

  id("com.google.cloud.tools.jib") version "2.0.0" apply false

  // Local plugins
//  id("plugin-version")
//  id("plugin-group")
}

//repositories {
//  mavenLocal()
//  mavenCentral()
//  maven("https://jitpack.io")
//}

allprojects {
//
  apply(plugin = "base")
  apply(plugin = "java")
//
  apply(plugin = "plugin-version")
//  apply(plugin = "plugin-group")
  setGroup("au.com.mebank.integration.soap")

  repositories {
    jcenter()
    mavenLocal()
    mavenCentral()
    maven("https://jitpack.io")
  }
//
  dependencies {
    implementation(kotlin("stdlib-jdk8", "1.3.61"))
  }
//
//  tasks.withType<Test> {
//    useJUnitPlatform()
//  }
//
//  java {
//    sourceCompatibility = JavaVersion.VERSION_11
//    targetCompatibility = JavaVersion.VERSION_11
//  }
//
  tasks.withType<KotlinCompile> {
    kotlinOptions {
      freeCompilerArgs = listOf("-Xjsr305=strict")
      jvmTarget = "11" // JavaVersion.VERSION_11
    }
  }
}

val gradleWrapperVersion: String by project
tasks {
  wrapper {
    gradleVersion = gradleWrapperVersion
    distributionType = Wrapper.DistributionType.ALL
  }
}
