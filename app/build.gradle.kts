buildscript {
  dependencies {
//    classpath("com.google.guava:guava:28.1-jre")
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
  id("java")

  kotlin("jvm")
  kotlin("kapt")
  kotlin("plugin.spring")

  id("org.springframework.boot")
  id("io.spring.dependency-management")

  id("com.google.cloud.tools.jib")

  id("publishing")
  id("maven-publish")

  id("plugin-testing")
}

val apacheCXFVersion: String by project
val javaxXmlVersion: String by project
val sunXmlVersion: String by project
val javaxActivation: String by project
val springVersion: String by project

dependencies {

/*
  implementation(project(path = ":model"))
  implementation(project(path = ":api"))
*/
  kapt("org.springframework.boot", "spring-boot-configuration-processor", springVersion)

  implementation(project(path = ":api"))
//  implementation("au.com.mebank.integration.soap", "api", "f11d25a")
//  implementation("au.com.mebank.integration.soap", "api", "+")
  implementation(project(path = ":model"))
//  implementation("au.com.mebank.integration.soap:model:f11d25a")
//  implementation("au.com.mebank.integration.soap", "model", "+")

  implementation("org.springframework.boot", "spring-boot-starter-webflux", springVersion)
  implementation("org.springframework.boot", "spring-boot-starter-actuator", springVersion)
  implementation("com.fasterxml.jackson.module", "jackson-module-kotlin")

  implementation("org.apache.cxf", "cxf-spring-boot-starter-jaxws", apacheCXFVersion)

  implementation("org.springframework.ws", "spring-ws-core")

  testImplementation("org.springframework.boot:spring-boot-starter-test") {
    exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
  }

  testImplementation("com.github.JensPiegsa:wiremock-extension:0.4.0")
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.2")
  testImplementation("org.junit.jupiter:junit-jupiter-engine:5.5.2")
  testImplementation("org.junit.jupiter:junit-jupiter-params:5.5.2")
  testImplementation("io.projectreactor:reactor-test")

  testImplementation("org.testcontainers:testcontainers:1.10.6")
  testImplementation("org.testcontainers:junit-jupiter:1.10.6")
  testImplementation("org.testcontainers:selenium:1.10.6")
}

tasks.getByName<Jar>("jar") {
  enabled = true
}

publishing {
  publications {
    create<MavenPublication>("bootJava") {
      artifact(tasks.getByName("bootJar"))
    }
  }
}

jib {
  to {
    image = "johnlayton/amberleyway"
    tags = setOf(project.version as String)
    credHelper = "osxkeychain"
  }
}