plugins {
  id("java-library")

  kotlin("jvm")
  kotlin("kapt")

  id("publishing")
  id("maven-publish")

  id("plugin-wsdl")
  id("plugin-utils")
}

wsdlToJava {
  wsdls {
    register("amberleyway") {
      wsdl.set(file("${projectDir}/src/amberleyway/resources/amberleyway.wsdl"))
      pkgs.put("http://mebank.com.au/service", "com.github.johnlayton.amberleyway.api")
    }
  }
}

publishing {
  publications {
    create<MavenPublication>("default") {
      from(components["java"])
    }
  }
}

