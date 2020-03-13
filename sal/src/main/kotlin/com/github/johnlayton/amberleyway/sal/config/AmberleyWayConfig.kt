package com.github.johnlayton.amberleyway.sal.config

import com.github.johnlayton.amberleyway.AmberleyWay
import com.github.johnlayton.amberleyway.sal.client.AmberleyWayClient
import com.github.johnlayton.amberleyway.sal.client.AmberleyWayClientImpl
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.xml.ws.soap.SOAPBinding
import javax.validation.Valid

//@ConstructorBinding
//@EnableConfigurationProperties(ClientConfig::class)
//@Configuration
//@ConfigurationProperties(prefix = "service")
//data class ClientProperties(
//        val address: String
//)
//
@Configuration
@EnableConfigurationProperties(AmberleyWayProperties::class)
//@ConfigurationProperties(prefix = "service")
class AmberleyWayConfig(@Valid private val clientProperties: AmberleyWayProperties) {
//@ConstructorBinding
//constructor


//  @Value("\${service.address}")
//  internal var address: String? = null

//  data class Account(val bsb : String,
//                     val account : String)

  @Bean
  fun client(amberleyWay : AmberleyWay): AmberleyWayClient {
//    val account : Account = Regex("([0-9]{6})\\-([0-9]{9})").find("foo")?.destructured?.let { (bsb, account) -> Account() } ?: Account()
//    { (bsb, account) ->
//      return Account(bsb, account)
//    }



    return AmberleyWayClientImpl(amberleyWay)
//    return DemoWebClient(clientProperties.address)
  }

  @Bean
  fun demoService() : AmberleyWay {
    val jaxWsProxyFactoryBean = JaxWsProxyFactoryBean()
    jaxWsProxyFactoryBean.serviceClass = AmberleyWay::class.java
    jaxWsProxyFactoryBean.address = clientProperties.address
    jaxWsProxyFactoryBean.bindingId = SOAPBinding.SOAP12HTTP_BINDING
//    jaxWsProxyFactoryBean.features.add(customSoapFeature)

    return jaxWsProxyFactoryBean.create() as AmberleyWay
  }

//  @Bean
//  fun client(): WebClient {
//
//    return WebClient.builder()
//        .baseUrl(address!!)
///*
//        .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/vnd.github.v3+json")
//        .defaultHeader(HttpHeaders.USER_AGENT, "Spring 5 WebClient")
//*/
//        .build();
//
//  }

}