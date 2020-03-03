import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
//    id("java")
//    id("publishing")
//    id("maven-publish")
//    `kotlin-dsl`
    `java-library`
    `maven-publish`

    kotlin("jvm")

    // Local plugins
//    id("plugin-version")
//    id("plugin-group")
}

dependencies {
    api("javax.xml.bind:jaxb-api:2.3.1")
}

publishing {
    publications {
        create<MavenPublication>("default") {
            from(components["java"])
        }
    }
}