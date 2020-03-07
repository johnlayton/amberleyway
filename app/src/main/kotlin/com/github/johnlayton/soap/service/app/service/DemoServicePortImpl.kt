package com.github.johnlayton.soap.service.app.service

import com.github.johnlayton.soap.service.model.DemoRequest
import com.github.johnlayton.soap.service.model.DemoResponse
import javax.jws.WebService

@WebService(
    serviceName = "DemoService",
    portName = "DemoServicePort",
    targetNamespace = "http://mebank.com.au/service",
    endpointInterface = "com.github.johnlayton.soap.service.app.service.DemoService")
class DemoServicePortImpl : DemoService {

  override fun sayHello(request: DemoRequest): DemoResponse {
    return DemoResponse(request.id,
        "Hello ${request.name}!!!");
  }

}