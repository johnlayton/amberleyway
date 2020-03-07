package com.github.johnlayton.soap.service.sal.client

import com.github.johnlayton.soap.service.sal.model.DemoRequest
import com.github.johnlayton.soap.service.sal.model.DemoResponse

import reactor.core.publisher.Mono

interface DemoClient {
  fun sayHello(request: DemoRequest) : Mono<DemoResponse>
}