package com.github.johnlayton.amberleyway.app.service

import com.github.johnlayton.amberleyway.model.AmberleyWayRequest
import com.github.johnlayton.amberleyway.model.AmberleyWayResponse
import javax.jws.WebService

@WebService(
    serviceName = "AmberleyWay",
    portName = "AmberleyWayImpl",
    targetNamespace = "http://johnlayton.github.com/amberleyway",
    endpointInterface = "com.github.johnlayton.amberleyway.app.service.AmberleyWayService")
class AmberleyWayServiceImpl : AmberleyWayService {

  override fun sayHello(request: AmberleyWayRequest): AmberleyWayResponse {
    return AmberleyWayResponse(request.id,
        "Hello ${request.name}!!!");
  }

}