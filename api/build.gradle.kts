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
    register("demo") {
      wsdl.set(file("${projectDir}/src/demo/resources/demo.wsdl"))
      pkgs.put("http://mebank.com.au/service", "com.github.johnlayton.soap.service.api.model")
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

