package com.github.johnlayton.amberleyway.sal.client

import com.github.johnlayton.amberleyway.sal.model.AmberleyWayRequest
import com.github.johnlayton.amberleyway.sal.model.AmberleyWayResponse

import reactor.core.publisher.Mono

interface AmberleyWayClient {
  fun sayHello(request: AmberleyWayRequest) : Mono<AmberleyWayResponse>
}