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
      pkgs.put("http://johnlayton.github.com/amberleyway", "com.github.johnlayton.amberleyway.api.model")
    }
  }
}

publishing {
  publications {
    create<MavenPublication>("default") {
      from(components["java"])
//      from(components["amberleyway"])
    }
  }
}

//configurations {
//  create("spi")
//}
//
//tasks.register<Jar>("spiJar") {
//  archiveBaseName.set("api-spi")
//  from(project.the<SourceSetContainer>()["amberleyway"].output)
////  include("org/gradle/sample/api/**")
//}
//
//artifacts {
//  add("spi", tasks["spiJar"])
//}

//artifacts {
//  add("all", tasks["jar"])
//}