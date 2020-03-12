package com.github.johnlayton.amberleyway.app.service

import com.github.johnlayton.amberleyway.model.AmberleyWayRequest
import com.github.johnlayton.amberleyway.model.AmberleyWayResponse
import javax.jws.WebMethod
import javax.jws.WebParam
import javax.jws.WebResult
import javax.jws.WebService
import javax.jws.soap.SOAPBinding
import javax.xml.ws.RequestWrapper
import javax.xml.ws.ResponseWrapper

@WebService(name = "AmberleyWay",
    targetNamespace = "http://johnlayton.github.com/amberleyway")
@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.ENCODED, parameterStyle = SOAPBinding.ParameterStyle.BARE)
interface AmberleyWayService {

  @WebMethod(operationName = "sayHello")
  @RequestWrapper(
      targetNamespace = "http://johnlayton.github.com/amberleyway",
      className = "com.github.johnlayton.soap.service.model.DemoRequest")
  @ResponseWrapper(
      targetNamespace = "http://johnlayton.github.com/amberleyway",
      className = "com.github.johnlayton.soap.service.model.DemoResponse")
  @WebResult(name = "response", targetNamespace = "http://johnlayton.github.com/amberleyway")
  fun sayHello(@WebParam(name = "request") request: AmberleyWayRequest): AmberleyWayResponse
}