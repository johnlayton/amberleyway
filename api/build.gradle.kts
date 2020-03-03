plugins {
  `java-library`
  `maven-publish`

  kotlin("jvm")

  // Local plugins
//    id("integration")
//    id("plugin-group")
//    id("plugin-version")
//    id("plugin-wsdl") version "0.0.1"
//    id("plugin-utils")
  id("plugin-wsdl")
}

/*
configure<WsdlToJavaExtension> {
    apacheCXFVersion = "3.3.4"
    wsdls {
        register("demo") {
            wsdl.set(file("${projectDir}/src/demo/resources/Demo.wsdl"))
//            pkgs.put("http://mebank.com.au/service", "au.com.mebank.integration.service")
        }
    }
}
*/

//apply(plugin = "plugin-wsdl")

wsdlToJava {

  logger.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
  logger.info("++ Configure the WSDL Plugin")
  logger.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")

//    apacheCXFVersion = "3.3.4"
  wsdls {
    register("demo") {
      wsdl.set(file("${projectDir}/src/demo/resources/demo.wsdl"))
//            http://localhost:8092/service/demo?wsdl
      pkgs.put("http://mebank.com.au/service", "au.com.mebank.soap.service.api.model")
//            pkgs.put("tns", "au.com.mebank.integration.service.api")
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
